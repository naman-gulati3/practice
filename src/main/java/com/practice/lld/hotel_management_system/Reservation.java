package com.practice.lld.hotel_management_system;

import java.time.LocalDate;

public class Reservation {
  private final String id;
  private final Guest guest;
  private final Room room;

  private final LocalDate startDate;
  private final LocalDate endDate;
  private ReservationStatus reservationStatus;

  public Reservation(String id, Guest guest, Room room, LocalDate startDate, LocalDate endDate) {
    this.id = id;
    this.guest = guest;
    this.room = room;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public synchronized void cancel() {
    if (this.reservationStatus == ReservationStatus.CONFIRMED) {
      this.reservationStatus = ReservationStatus.CANCELLED;
    } else {
      throw new IllegalArgumentException("Reservation is already cancelled");
    }
  }

  public String getId() {
    return id;
  }

  public Guest getGuest() {
    return guest;
  }

  public Room getRoom() {
    return room;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public ReservationStatus getReservationStatus() {
    return reservationStatus;
  }
}
