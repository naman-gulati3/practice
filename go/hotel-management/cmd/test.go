package main

import (
	"fmt"
	"sync"
)

func executeParallel(ch chan<- int, functions ...func() int) {
	var wg sync.WaitGroup
	wg.Add(len(functions))

	for _, f := range functions {
		go func(fn func() int) {
			defer wg.Done()
			ch <- fn()
		}(f)
	}

	go func() {
		wg.Wait()
		close(ch)
	}()
}

func exampleFunction(counter int) int {
	sum := 0
	for i := 0; i < counter; i++ {
		sum += 1
	}
	return sum
}

func main() {
	// expensiveFunction := func() int { return exampleFunction(200000000) }
	// cheapFunction := func() int { return exampleFunction(10000000) }

	// ch := make(chan int)

	// go executeParallel(ch, expensiveFunction, cheapFunction)

	// for result := range ch {
	// 	fmt.Printf("Result: %d\n", result)
	// }

	var wg sync.WaitGroup
	max := 100
	evenChan := make(chan bool)
	oddChan := make(chan bool)
	wg.Add(2)
	go printEvenNums(max, evenChan, oddChan, &wg)
	go printOddNums(max, evenChan, oddChan, &wg)
	oddChan <- true
	wg.Wait()
	close(evenChan)
	close(oddChan)
}

func printOddNums(max int, evenChan chan bool, oddChan chan bool, wg *sync.WaitGroup) {
	defer wg.Done()
	for i := 1; i <= max; i += 2 {
		<-oddChan
		fmt.Println(i)
		if i+1 <= max {
			evenChan <- true
		}
	}
}

func printEvenNums(max int, evenChan chan bool, oddChan chan bool, wg *sync.WaitGroup) {
	defer wg.Done()

	for i := 2; i <= max; i += 2 {
		<-evenChan
		fmt.Println(i)
		if i+1 <= max { // Only signal if there's an odd number to print
			oddChan <- true
		}
	}
}
