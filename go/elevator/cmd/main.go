package main

import (
	"elevator/model"
	"time"
)

func main() {
	ec := model.NewElevatorController(3, 10)
	defer ec.Stop()

	ec.RequestElevator(1, 10)
	ec.RequestElevator(2, 4)
	ec.RequestElevator(5, 2)
	ec.RequestElevator(10, 4)

	time.Sleep(30 * time.Second)
}
