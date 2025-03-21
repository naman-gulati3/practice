package model

import "time"

type Slot struct {
	ID            int       `json:"id"`
	Number        int       `json:"number"`
	IsOccupied    bool      `json:"is_occupied"`
	ParkedVehicle *Vehicle  `json:"parked_vehicle"`
	OccupiedAt    time.Time `json:"occupied_at"`
}
