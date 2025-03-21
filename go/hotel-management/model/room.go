package model

import "time"

type Room struct {
	Number        int `json:"number"`
	NumOfBeds     int `json:"num_of_beds"`
	IsOccupied    bool
	CheckInDate   *time.Time
	CheckOutDate  *time.Time
	Guests        map[int]*Guest
	PricePerNight float64
	RoomType      string
}
