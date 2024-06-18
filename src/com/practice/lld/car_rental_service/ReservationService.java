package com.practice.lld.car_rental_service;

import java.time.LocalDate;

public interface ReservationService {
   Reservation createReservation(Customer customer, Car car, LocalDate startDate, LocalDate endData);

  void cancelReservation(String reservationId);
}
