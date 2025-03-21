package model

import (
	"fmt"
	"math"
	"sync"
)

type ElevatorController struct {
	elevators []*Elevator
	mu        sync.RWMutex
}

func NewElevatorController(numElevators int, capacity int) *ElevatorController {
	controller := &ElevatorController{
		elevators: make([]*Elevator, numElevators),
	}
	for i := 0; i < numElevators; i++ {
		elevator := NewElevator(i+1, capacity)
		controller.elevators[i] = elevator
		elevator.Run()
	}

	return controller
}

func (c *ElevatorController) RequestElevator(sourceFloor int, destFloor int) {
	elevator := c.FindOptimalElevator(sourceFloor, destFloor)
	request := NewRequest(sourceFloor, destFloor)

	elevator.AddRequest(request)
}

func (c *ElevatorController) FindOptimalElevator(sourceFloor int, destFloor int) *Elevator {
	c.mu.RLock()
	defer c.mu.RUnlock()

	var optimalElevator *Elevator
	minDistance := -1

	for _, elevator := range c.elevators {
		currentFloor := elevator.GetCurrentFloor()
		distance := int(math.Abs(float64(currentFloor) - float64(sourceFloor)))

		fmt.Printf("Checking elevator %d at floor %d, distance: %d\n",
			elevator.id, currentFloor, distance)

		if minDistance == -1 || distance <= minDistance {
			minDistance = distance
			optimalElevator = elevator
		}
	}

	fmt.Printf("Selected elevator %d with distance %d\n",
		optimalElevator.id, minDistance)
	return optimalElevator
}

func (c *ElevatorController) Stop() {
	c.mu.Lock()
	defer c.mu.Unlock()
	for _, elevator := range c.elevators {
		elevator.Stop()
	}
}
