package com.practice.lld.hotel_management_system;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HotelManagementService {
  private static HotelManagementService instance;
  private final Map<String, Guest> guests;

  private final Map<Integer, Room> rooms;

  private final Map<String, Reservation> reservations;

  private HotelManagementService() {
    this.guests = new ConcurrentHashMap<>();
    this.reservations = new ConcurrentHashMap<>();
    this.rooms = new ConcurrentHashMap<>();
  }

  public HotelManagementService getInstance() {
    if(instance == null) {
      instance = new HotelManagementService();
    }
    return instance;
  }

  public void addGuest(Guest guest) {
    this.guests.put(guest.getId(), guest);
  }

  public Guest getGuest(String id) {
    return this.guests.get(id);
  }

  public void addRoom(Room room) {
    this.rooms.put(room.getRoomNumber(), room);
  }

  public Room getRoom(int roomNumber) {
    return this.rooms.get(roomNumber);
  }

  public synchronized Reservation bookRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
    if(!alreadyBooked(room)) {
      room.book();
      String reservationId = genReservationId();
      Reservation reservation = new Reservation(reservationId, guest, room, checkInDate, checkOutDate);
      this.reservations.put(reservationId, reservation);
      return reservation;
    }
    return null;
  }

  public synchronized void checkIn(String reservationId) {
    Reservation reservation = this.reservations.get(reservationId);
    if(reservation != null && reservation.getReservationStatus() == ReservationStatus.CONFIRMED) {
      reservation.getRoom().checkIn();
    } else {
     throw new IllegalArgumentException("Reservation does not exist or is not confirmed yet.");
    }
  }

  public synchronized void checkOut(String reservationId, PaymentProcessor paymentProcessor) {
    Reservation reservation = this.reservations.get(reservationId);
    if(reservation != null && reservation.getReservationStatus() == ReservationStatus.CONFIRMED) {
      Room room = reservation.getRoom();
      float amount = room.getPricePerNight() * Duration.between(reservation.getStartDate(), reservation.getEndDate()).toDays();
      if(paymentProcessor.processPayment(amount)) {
        room.checkOut();
        reservations.remove(reservationId);
      } else {
        throw new IllegalArgumentException("Payment not processed");
      }
    } else {
     throw new IllegalArgumentException("Reservation does not exist or is not confirmed yet.");
    }
  }

  private boolean alreadyBooked(Room room) {
    return room.getRoomStatus().equals(RoomStatus.AVAILABLE);
  }

  private String genReservationId() {
    return UUID.randomUUID().toString();
  }
}
