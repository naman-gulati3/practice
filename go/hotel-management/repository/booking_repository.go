package repository

import (
	"hotel-management/model"
	"time"
)

type BookingRepository interface {
	CreateHotel(rooms *[]model.Room) *model.Hotel
	CreateRoom(roomNum int, roomType string, pricePerNight float64) *model.Room
	FindAvailableRoom(hotel *model.Hotel, numOfGuests int, roomType string) (room *model.Room, err error)
	CreateBooking(hotel *model.Hotel, room *model.Room, guests []model.Guest, numOfDays int, checkInDate time.Time, checkOutDate time.Time) *model.Booking
}

type repo struct{}

func NewBookingRepository() BookingRepository {
	return &repo{}
}

func (r *repo) CreateRoom(roomNum int, roomType string, pricePerNight float64) *model.Room {
	return &model.Room{
		Number:        roomNum,
		NumOfBeds:     2,
		IsOccupied:    false,
		Guests:        make(map[int]*model.Guest),
		PricePerNight: pricePerNight,
		RoomType:      roomType,
	}
}

func (r *repo) CreateHotel(rooms *[]model.Room) *model.Hotel {
	roomsMp := make(map[int]*model.Room)
	for _, room := range *rooms {
		roomsMp[room.Number] = &room
	}

	return &model.Hotel{
		Address:    "Delhi",
		TotalRooms: len(*rooms),
		Rooms:      roomsMp,
	}
}

func (r *repo) FindAvailableRoom(hotel *model.Hotel, numOfGuests int, roomType string) (room *model.Room, err error) {
	return hotel.GetAvailableRoom(numOfGuests, roomType)
}

func (r *repo) CreateBooking(hotel *model.Hotel, room *model.Room, guests []model.Guest, numOfDays int, checkInDate time.Time, checkOutDate time.Time) *model.Booking {
	guestMap := make(map[int]*model.Guest)
	for i, guest := range guests {
		guestMap[i] = &guest
	}

	room.CheckInDate = &checkInDate
	room.CheckOutDate = &checkOutDate
	room.Guests = guestMap
	room.IsOccupied = true
	hotel.Rooms[room.Number] = room

	return &model.Booking{
		Amount:    room.PricePerNight * float64(numOfDays),
		IsPaid:    true,
		RoomNum:   room.Number,
		Rooms:     *room,
		CreatedAt: time.Now(),
	}
}
