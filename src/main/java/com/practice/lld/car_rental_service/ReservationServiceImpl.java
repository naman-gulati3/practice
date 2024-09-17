package com.practice.lld.car_rental_service;

import com.practice.lld.car_rental_service.payment.CashPaymentProcessor;
import com.practice.lld.car_rental_service.payment.PaymentProcessor;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ReservationServiceImpl implements ReservationService {
  private static ReservationServiceImpl instance;
  private final Map<String, Car> cars;
  private final Map<String, Reservation> reservations;
  private final PaymentProcessor paymentProcessor;

  private ReservationServiceImpl() {
    this.cars = new ConcurrentHashMap<>();
    this.reservations = new ConcurrentHashMap<>();
    this.paymentProcessor = new CashPaymentProcessor();
  }

  public static synchronized ReservationServiceImpl getInstance() {
    if (instance == null) {
      instance = new ReservationServiceImpl();
    }
    return instance;
  }

  @Override
  public synchronized Reservation createReservation(
      Customer customer, Car car, LocalDate startDate, LocalDate endData) {
    if (isCarAvailable(car, startDate, endData)) {
      var reservationId = generateReservationId();
      var reservation = new Reservation(reservationId, customer, car, startDate, endData);
      this.reservations.put(reservationId, reservation);
      car.setAvailable(false);
      return reservation;
    }
    return null;
  }

  public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate) {
    return cars.values().stream()
        .filter(
            car ->
                car.getMake().equals(make)
                    && car.getModel().equals(model)
                    && isCarAvailable(car, startDate, endDate))
        .toList();
  }

  private String generateReservationId() {
    return UUID.randomUUID().toString();
  }

  private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
    for (Reservation reservation : reservations.values()) {
      if (reservation.getCar().equals(car)) {
        if (startDate.isBefore(reservation.getEndData())
            && endDate.isAfter(reservation.getStartDate())) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public synchronized void cancelReservation(String reservationId) {
    Reservation removedReservation = reservations.get(reservationId);
    if (removedReservation != null) {
      removedReservation.getCar().setAvailable(true);
    }
  }

  public boolean processPayment(Reservation reservation) {
    return this.paymentProcessor.processPayment(reservation.getPrice());
  }

  public void addCar(Car car) {
    cars.put(car.getLicensePlateNumber(), car);
  }

  public void removeCar(Car car) {
    cars.remove(car.getLicensePlateNumber());
  }
}
