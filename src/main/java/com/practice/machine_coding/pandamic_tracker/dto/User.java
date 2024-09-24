package com.practice.machine_coding.pandamic_tracker.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

  private final String name;
  private final String phoneNumber;
  private final int pinCode;
  private boolean contactWithPositivePatient;
  private boolean travelledInPast15Days;
  private final List<Symptom> symptoms;

  public User(String name, String phoneNumber, int pinCode) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.pinCode = pinCode;
    this.contactWithPositivePatient = false;
    this.travelledInPast15Days = false;
    this.symptoms = new ArrayList<>();
  }

  public List<Symptom> getSymptoms() {
    return symptoms;
  }

  public void addSymptom(Symptom... patientSymptoms) {
    this.symptoms.addAll(Arrays.asList(patientSymptoms));
  }

  public boolean isTravelledInPast15Days() {
    return travelledInPast15Days;
  }

  public void setTravelledInPast15Days(boolean travelledInPast15Days) {
    this.travelledInPast15Days = travelledInPast15Days;
  }

  public boolean isContactWithPositivePatient() {
    return contactWithPositivePatient;
  }

  public void setContactWithPositivePatient(boolean contactWithPositivePatient) {
    this.contactWithPositivePatient = contactWithPositivePatient;
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public int getPinCode() {
    return pinCode;
  }
}
