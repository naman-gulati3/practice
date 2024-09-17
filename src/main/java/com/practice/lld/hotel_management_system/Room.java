package com.practice.lld.hotel_management_system;


public class Room {
  private final int roomNumber;

  private final float pricePerNight;

  private final RoomType roomType;

  private RoomStatus roomStatus;

  public Room(int roomNumber, float pricePerNight, RoomType roomType) {
    this.roomNumber = roomNumber;
    this.pricePerNight = pricePerNight;
    this.roomType = roomType;
    this.roomStatus = RoomStatus.AVAILABLE;
  }

  public synchronized void book() {
    if (this.roomStatus == RoomStatus.AVAILABLE) {
      this.roomStatus = RoomStatus.BOOKED;
    } else {
      throw new IllegalArgumentException("Room is already booked");
    }
  }

  public synchronized void checkIn() {
    if (this.roomStatus == RoomStatus.BOOKED) {
      this.roomStatus = RoomStatus.OCCUPIED;
    } else {
      throw new IllegalArgumentException("Room is not booked");
    }
  }

  public synchronized void checkOut() {
    if (this.roomStatus == RoomStatus.OCCUPIED) {
      this.roomStatus = RoomStatus.AVAILABLE;
    } else {
      throw new IllegalArgumentException("Room is not occupied");
    }
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public float getPricePerNight() {
    return pricePerNight;
  }

  public RoomType getRoomType() {
    return roomType;
  }

  public RoomStatus getRoomStatus() {
    return roomStatus;
  }

  public void setRoomStatus(RoomStatus roomStatus) {
    this.roomStatus = roomStatus;
  }
}
