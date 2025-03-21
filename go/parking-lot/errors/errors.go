package errors

import "errors"

var (
	ErrParkingLotFull      = errors.New("parking lot is full")
	ErrSlotAlreadyOccupied = errors.New("slot is already occupied")
	ErrSlotNotFound        = errors.New("slot not found")
	ErrVehicleNotFound     = errors.New("vehicle not found")
)
