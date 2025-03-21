package main

// import (
// 	"fmt"
// 	"hotel-management/model"
// 	"hotel-management/repository"
// 	"hotel-management/service"
// 	"time"
// )

// func main() {
// 	repo := repository.NewBookingRepository()
// 	service := service.NewBookingService(repo)

// 	room1 := service.CreateRoom(1, "Standard", 500)
// 	room2 := service.CreateRoom(2, "Standard", 500)
// 	room3 := service.CreateRoom(3, "Standard", 500)
// 	room4 := service.CreateRoom(4, "Deluxe", 1000)
// 	room5 := service.CreateRoom(5, "Deluxe", 1000)
// 	room6 := service.CreateRoom(6, "Deluxe", 1000)
// 	room7 := service.CreateRoom(7, "Suite", 1500)
// 	room8 := service.CreateRoom(8, "Suite", 1500)

// 	hotel := service.InitialzeHotel([]model.Room{*room1, *room2, *room3, *room4, *room5, *room6, *room7, *room8})

// 	guest := model.NewGuest("Naman")

// 	room, _ := service.BookRoom(hotel, []model.Guest{*guest, *guest}, "Suite", 2, time.Now(), time.Now().Add(2*time.Hour*24))

// 	fmt.Println(room)
// 	service.GetHotelStatus(hotel)
// }
