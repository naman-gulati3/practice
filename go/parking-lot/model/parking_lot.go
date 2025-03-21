package model

import (
	"parking-lot/errors"
	"time"
)

type ParkingLot struct {
	Capacity       int `json:"capacity"`
	OccupiedSlots  int `json:"occupied_slots"`
	AvailableSpots map[int]*Slot
	HourlyRate     float64 `json:"hourly_rate"`
}

func NewParkingLot(capacity int, hourlyRate float64) *ParkingLot {
	lot := &ParkingLot{
		Capacity:       capacity,
		OccupiedSlots:  0,
		AvailableSpots: make(map[int]*Slot),
		HourlyRate:     hourlyRate,
	}

	for i := 1; i <= capacity; i++ {
		lot.AvailableSpots[i] = &Slot{
			ID:         i,
			Number:     i,
			IsOccupied: false,
		}
	}
	return lot
}

func (p *ParkingLot) ParkVehicle(vehicle *Vehicle) (*Slot, error) {
	if p.OccupiedSlots >= p.Capacity {
		return nil, errors.ErrParkingLotFull
	}

	for _, slot := range p.AvailableSpots {
		if !slot.IsOccupied {
			slot.IsOccupied = true
			slot.ParkedVehicle = vehicle
			slot.OccupiedAt = time.Now()
			p.OccupiedSlots++
			return slot, nil
		}
	}
	return nil, errors.ErrParkingLotFull
}

func (p *ParkingLot) RemoveVehicle(slotNumber int) error {
	slot, exists := p.AvailableSpots[slotNumber]
	if !exists {
		return errors.ErrSlotNotFound
	}

	if !slot.IsOccupied {
		return errors.ErrVehicleNotFound
	}

	slot.IsOccupied = false
	slot.ParkedVehicle = nil
	p.OccupiedSlots--
	return nil
}

func (p *ParkingLot) GetSlot(slotNumber int) (*Slot, error) {
	slot, exists := p.AvailableSpots[slotNumber]
	if !exists {
		return nil, errors.ErrSlotNotFound
	}
	return slot, nil
}
