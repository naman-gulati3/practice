package com.practice.machine_coding.pandamic_tracker.repository;

import com.practice.machine_coding.pandamic_tracker.dto.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZoneRepository {

  private final Map<Integer, List<User>> patientsByPincode;


  public ZoneRepository() {
    this.patientsByPincode = new ConcurrentHashMap<>();
  }

  public void addUserToZone(User user, boolean isPatientRecovered) {

    List<User> usersByPincode = this.patientsByPincode.getOrDefault(user.getPinCode(),
        new ArrayList<>());

    if (isPatientRecovered) {
      if (usersByPincode.stream()
          .anyMatch(u -> u.getPhoneNumber().equals(user.getPhoneNumber()))) {
        usersByPincode.removeIf(u -> u.getPhoneNumber().equals(user.getPhoneNumber()));
      }
    } else {
      if (usersByPincode.stream()
          .noneMatch(u -> u.getPhoneNumber().equals(user.getPhoneNumber()))) {
        usersByPincode.add(user);
      }
    }

    System.out.printf("Updated report for patient: %s and pincode: %s\n", user.getPhoneNumber(),
        user.getPinCode());
    this.patientsByPincode.put(user.getPinCode(), usersByPincode);
  }

  public int getInfectedPatientsByPincode(int pincode) {
    return this.patientsByPincode.getOrDefault(pincode, new ArrayList<>()).size();
  }
}
