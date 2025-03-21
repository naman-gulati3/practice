package model

import (
	"time"
)

type Booking struct {
	Amount    float64
	IsPaid    bool
	RoomNum   int
	Rooms     Room
	CreatedAt time.Time
}
