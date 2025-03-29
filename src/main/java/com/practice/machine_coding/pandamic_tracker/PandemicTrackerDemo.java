package com.practice.machine_coding.pandamic_tracker;

import com.practice.machine_coding.pandamic_tracker.dto.Admin;
import com.practice.machine_coding.pandamic_tracker.dto.PatientHealthResult;
import com.practice.machine_coding.pandamic_tracker.dto.Symptom;
import com.practice.machine_coding.pandamic_tracker.dto.User;
import com.practice.machine_coding.pandamic_tracker.repository.UserRepository;
import com.practice.machine_coding.pandamic_tracker.repository.ZoneRepository;
import com.practice.machine_coding.pandamic_tracker.service.PandemicTrackerService;
import com.practice.machine_coding.pandamic_tracker.service.PandemicTrackerServiceImpl;

public class PandemicTrackerDemo {

  public static void main(String[] args) {
    User user1 = new User("Naman", "7417833551", 247667);
    User user2 = new User("ABC", "123134121", 3412131);
    User user3 = new User("XYZ", "431421343", 247667);
    User user4 = new User("Anon", "4512419983", 247667);

    user3.addSymptom(Symptom.COUGH, Symptom.HEADACHE);
    user4.setTravelledInPast15Days(true);
    user4.setContactWithPositivePatient(true);
    user1.addSymptom(Symptom.FEVER);

    Admin admin = new Admin("admin123");

    UserRepository userRepository = new UserRepository();
    ZoneRepository zoneRepository = new ZoneRepository();

    PandemicTrackerService pandemicTrackerService =
        new PandemicTrackerServiceImpl(userRepository, zoneRepository);

    pandemicTrackerService.registerUser(user1);
    pandemicTrackerService.registerUser(user2);
    pandemicTrackerService.setPatientHealthResult(
        new PatientHealthResult(
            admin, user3.getName(), user3.getPhoneNumber(), user3.getPinCode(), false));
    pandemicTrackerService.registerUser(user4);

    System.out.println(pandemicTrackerService.calculateRiskFactor(user1.getPhoneNumber()));
    System.out.println(pandemicTrackerService.calculateRiskFactor(user2.getPhoneNumber()));
    System.out.println(pandemicTrackerService.calculateRiskFactor(user3.getPhoneNumber()));
    System.out.println(pandemicTrackerService.calculateRiskFactor(user4.getPhoneNumber()));

    System.out.println(pandemicTrackerService.getZoneStatus(247667));
    System.out.println(pandemicTrackerService.getZoneStatus(3412131));
  }
}
