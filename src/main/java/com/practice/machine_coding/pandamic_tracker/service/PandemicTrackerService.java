package com.practice.machine_coding.pandamic_tracker.service;

import com.practice.machine_coding.pandamic_tracker.dto.PatientHealthResult;
import com.practice.machine_coding.pandamic_tracker.dto.User;
import com.practice.machine_coding.pandamic_tracker.dto.Zone;
import java.util.Optional;

public interface PandemicTrackerService {

  void registerUser(User user);

  Optional<User> getUser(String phoneNumber);

  void setPatientHealthResult(PatientHealthResult patientHealthResult);

  double calculateRiskFactor(String phoneNumber);

  Zone getZoneStatus(int pincode);
}
