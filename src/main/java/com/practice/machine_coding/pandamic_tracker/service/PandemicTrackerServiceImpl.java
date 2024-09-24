package com.practice.machine_coding.pandamic_tracker.service;

import static com.practice.machine_coding.pandamic_tracker.constants.PandemicConstants.MORE_THAN_TWO_SYMPTOMS;
import static com.practice.machine_coding.pandamic_tracker.constants.PandemicConstants.NO_SYMPTOMS;
import static com.practice.machine_coding.pandamic_tracker.constants.PandemicConstants.ONE_SYMPTOMS;
import static com.practice.machine_coding.pandamic_tracker.constants.PandemicConstants.TWO_SYMPTOMS;

import com.practice.machine_coding.pandamic_tracker.dto.PatientHealthResult;
import com.practice.machine_coding.pandamic_tracker.dto.User;
import com.practice.machine_coding.pandamic_tracker.dto.Zone;
import com.practice.machine_coding.pandamic_tracker.repository.UserRepository;
import com.practice.machine_coding.pandamic_tracker.repository.ZoneRepository;
import java.util.Optional;

public class PandemicTrackerServiceImpl implements PandemicTrackerService {

  private final UserRepository userRepository;

  private final ZoneRepository zoneRepository;

  public PandemicTrackerServiceImpl(UserRepository userRepository, ZoneRepository zoneRepository) {
    this.userRepository = userRepository;
    this.zoneRepository = zoneRepository;
  }

  @Override
  public void registerUser(User user) {
    Optional<User> userFromStore = userRepository.getUserByPhoneNumber(user.getPhoneNumber());
    if (userFromStore.isPresent()) {
      throw new IllegalArgumentException(
          "User with phone number: %s is already registered".formatted(user.getPhoneNumber()));
    }
    System.out.printf("Registering user: %s\n", user.getPhoneNumber());
    userRepository.setUser(user);
  }

  @Override
  public Optional<User> getUser(String phoneNumber) {
    return userRepository.getUserByPhoneNumber(phoneNumber);
  }

  @Override
  public void setPatientHealthResult(PatientHealthResult patientHealthResult) {
    User user = new User(patientHealthResult.getName(), patientHealthResult.getPhoneNumber(),
        patientHealthResult.getPinCode());

    try {
      registerUser(user);
    } catch (IllegalArgumentException e) {
      System.out.printf(
          "User with phone number %s already registered, updating health report%n",
          patientHealthResult.getPhoneNumber());
    }

    System.out.printf("Admin: %s, updated report for patient: %s\n",
        patientHealthResult.getAdmin().name(), patientHealthResult.getName());
    zoneRepository.addUserToZone(user, patientHealthResult.isRecovered());
  }

  @Override
  public double calculateRiskFactor(String phoneNumber) {
    Optional<User> userFromStore = userRepository.getUserByPhoneNumber(phoneNumber);
    if (userFromStore.isEmpty()) {
      throw new IllegalArgumentException(
          "User with phone number: %s does not exist".formatted(phoneNumber));
    }

    User user = userFromStore.get();
    int numOfSymptoms = getNumberOfSymptoms(user);
    return switch (numOfSymptoms) {
      case 0 -> NO_SYMPTOMS;
      case 1 -> ONE_SYMPTOMS;
      case 2 -> TWO_SYMPTOMS;
      default -> MORE_THAN_TWO_SYMPTOMS;
    };
  }

  @Override
  public Zone getZoneStatus(int pincode) {
    int numInfectedPatients = zoneRepository.getInfectedPatientsByPincode(pincode);
    Zone zone;
    if (numInfectedPatients <= 0) {
      zone = Zone.GREEN;
    } else if (numInfectedPatients <= 5) {
      zone = Zone.ORANGE;
    } else {
      zone = Zone.RED;
    }

    System.out.printf("No. of positive cases: %s, zone status: %s\n", numInfectedPatients,
        zone.name());
    return zone;
  }


  private int getNumberOfSymptoms(User user) {
    int num = 0;
    if (user.isTravelledInPast15Days()) {
      num++;
    }

    if (user.isContactWithPositivePatient()) {
      num++;
    }

    num += user.getSymptoms().size();

    return num;
  }
}
