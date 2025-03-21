package repository

import "parking-lot/model"

type ParkingLotRepository interface {
	CreateParkingLot(capacity int, hourlyRate float64) *model.ParkingLot
	ParkVehicle(lot *model.ParkingLot, vehicle *model.Vehicle) (*model.Slot, error)
	RemoveVehicle(lot *model.ParkingLot, slotNumber int) error
	GetSlot(lot *model.ParkingLot, slotNumber int) (*model.Slot, error)
}

type parkingLotRepository struct{}

func NewParkingLotRepository() ParkingLotRepository {
	return &parkingLotRepository{}
}

func (r *parkingLotRepository) CreateParkingLot(capacity int, hourlyRate float64) *model.ParkingLot {
	return model.NewParkingLot(capacity, hourlyRate)
}

func (r *parkingLotRepository) ParkVehicle(lot *model.ParkingLot, vehicle *model.Vehicle) (*model.Slot, error) {
	return lot.ParkVehicle(vehicle)
}

func (r *parkingLotRepository) RemoveVehicle(lot *model.ParkingLot, slotNumber int) error {
	return lot.RemoveVehicle(slotNumber)
}

func (r *parkingLotRepository) GetSlot(lot *model.ParkingLot, slotNumber int) (*model.Slot, error) {
	return lot.GetSlot(slotNumber)
}
