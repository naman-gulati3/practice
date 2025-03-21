package service

import (
	"fmt"
	"hotel-management/model"
	"hotel-management/repository"
	"time"
)

type BookingService interface {
	CreateRoom(roomNum int, roomType string, pricePerNight float64) *model.Room
	InitialzeHotel(rooms []model.Room) *model.Hotel
	BookRoom(hotel *model.Hotel, guests []model.Guest, roomType string, numOfDays int, checkInDate time.Time, checkOutDate time.Time) (*model.Room, error)
	GetHotelStatus(hotel *model.Hotel)
}

type bookingService struct {
	repo repository.BookingRepository
}

func NewBookingService(repo repository.BookingRepository) BookingService {
	return &bookingService{repo: repo}
}

func (s *bookingService) CreateRoom(roomNum int, roomType string, pricePerNight float64) *model.Room {
	return s.repo.CreateRoom(roomNum, roomType, pricePerNight)
}

func (s *bookingService) InitialzeHotel(rooms []model.Room) *model.Hotel {
	return s.repo.CreateHotel(&rooms)
}

func (s *bookingService) BookRoom(hotel *model.Hotel, guests []model.Guest, roomType string, numOfDays int, checkInDate time.Time, checkOutDate time.Time) (*model.Room, error) {
	availableRoom, err := s.repo.FindAvailableRoom(hotel, len(guests), roomType)
	if err != nil {
		return nil, err
	}

	for i, guest := range guests {
		availableRoom.Guests[i] = &guest
	}

	availableRoom.CheckInDate = &checkInDate
	availableRoom.CheckOutDate = &checkOutDate
	availableRoom.IsOccupied = true
	fmt.Println("*** ")
	fmt.Println(availableRoom)
	hotel.Rooms[availableRoom.Number] = availableRoom

	_ = &model.Booking{
		Amount:    availableRoom.PricePerNight * float64(numOfDays),
		IsPaid:    true,
		RoomNum:   availableRoom.Number,
		Rooms:     *availableRoom,
		CreatedAt: time.Now(),
	}

	return availableRoom, nil
}

func (s *bookingService) GetHotelStatus(hotel *model.Hotel) {
	for _, room := range hotel.Rooms {
		fmt.Println(room)
	}
}
