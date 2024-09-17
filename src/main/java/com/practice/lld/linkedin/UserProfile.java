package com.practice.lld.linkedin;

import java.util.List;

public class UserProfile {

  private final User user;

  private String profilePicture;
  private String headline;
  private String summary;
  private List<String> experience;
  private List<String> education;
  private List<String> skills;

  public UserProfile(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public String getProfilePicture() {
    return profilePicture;
  }

  public void setProfilePicture(String profilePicture) {
    this.profilePicture = profilePicture;
  }

  public String getHeadline() {
    return headline;
  }

  public void setHeadline(String headline) {
    this.headline = headline;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public List<String> getExperience() {
    return experience;
  }

  public void setExperience(List<String> experience) {
    this.experience = experience;
  }

  public List<String> getEducation() {
    return education;
  }

  public void setEducation(List<String> education) {
    this.education = education;
  }

  public List<String> getSkills() {
    return skills;
  }

  public void setSkills(List<String> skills) {
    this.skills = skills;
  }
}
