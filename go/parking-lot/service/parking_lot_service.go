package service

import (
	"parking-lot/model"
	"parking-lot/repository"
)

type ParkingLotService interface {
	CreateParkingLot(capacity int, hourlyRate float64) *model.ParkingLot
	ParkVehicle(lot *model.ParkingLot, registrationNumber, color string) (*model.Slot, error)
	RemoveVehicle(lot *model.ParkingLot, slotNumber int) error
	GetSlot(lot *model.ParkingLot, slotNumber int) (*model.Slot, error)
}

type parkingLotService struct {
	repo repository.ParkingLotRepository
}

func NewParkingLotService(repo repository.ParkingLotRepository) ParkingLotService {
	return &parkingLotService{repo: repo}
}

func (s *parkingLotService) CreateParkingLot(capacity int, hourlyRate float64) *model.ParkingLot {
	return s.repo.CreateParkingLot(capacity, hourlyRate)
}

func (s *parkingLotService) ParkVehicle(lot *model.ParkingLot, registrationNumber, color string) (*model.Slot, error) {
	vehicle := &model.Vehicle{
		RegistationNumber: registrationNumber,
		Color:             color,
	}
	return s.repo.ParkVehicle(lot, vehicle)
}

func (s *parkingLotService) RemoveVehicle(lot *model.ParkingLot, slotNumber int) error {
	return s.repo.RemoveVehicle(lot, slotNumber)
}

func (s *parkingLotService) GetSlot(lot *model.ParkingLot, slotNumber int) (*model.Slot, error) {
	return s.repo.GetSlot(lot, slotNumber)
}
