package model

import (
	"fmt"
	"sync"
	"time"
)

type Elevator struct {
	id               int
	capacity         int
	currentFloor     int
	currentDirection Direction
	requests         chan *Request
	stopChan         chan struct{}
	mu               sync.RWMutex
}

func NewElevator(id int, capacity int) *Elevator {
	return &Elevator{
		id:               id,
		capacity:         capacity,
		currentFloor:     1,
		currentDirection: DirectionUp,
		requests:         make(chan *Request, capacity),
		stopChan:         make(chan struct{}),
	}
}

func (e *Elevator) AddRequest(request *Request) bool {
	select {
	case e.requests <- request:
		fmt.Printf("elevator %d added request: Floor %d to %d\n", e.id, request.SourceFloor, request.DestinationFloor)
		return true
	default:
		return false
	}
}

func (e *Elevator) GetCurrentFloor() int {
	e.mu.RLock()
	defer e.mu.RUnlock()

	return e.currentFloor
}

func (e *Elevator) SetCurrentFloor(floor int) {
	e.mu.Lock()
	defer e.mu.Unlock()

	e.currentFloor = floor
}

func (e *Elevator) Run() {
	fmt.Printf("running elevator %d\n", e.id)
	go func() {
		for {
			select {
			case request := <-e.requests:
				e.processRequest(request)
			case <-e.stopChan:
				return
			}
		}
	}()
}

func (e *Elevator) Stop() {
	close(e.stopChan)
}

func (e *Elevator) processRequest(request *Request) {
	startFloor := request.SourceFloor
	destFloor := request.DestinationFloor

	if startFloor > destFloor {
		e.currentDirection = DirectionDown
		for i := startFloor; i >= destFloor; i-- {
			e.SetCurrentFloor(i)
			fmt.Printf("elevator %d is on floor %d\n", e.id, e.currentFloor)
			time.Sleep(time.Second)
		}
	} else if startFloor < destFloor {
		e.currentDirection = DirectionUp
		for i := startFloor; i <= destFloor; i++ {
			e.SetCurrentFloor(i)
			fmt.Printf("elevator %d is on floor %d\n", e.id, e.currentFloor)
			time.Sleep(time.Second)
		}
	}
}
