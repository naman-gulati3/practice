package com.practice.lld.traffic_light;

public class TrafficLight {
  private final String id;
  private Signal currentSignal;
  private int redDuration;
  private int yellowDuration;
  private int greenDuration;

  public TrafficLight(String id, int redDuration, int yellowDuration, int greenDuration) {
    this.id = id;
    this.redDuration = redDuration;
    this.yellowDuration = yellowDuration;
    this.greenDuration = greenDuration;
    this.currentSignal = Signal.RED;
  }

  public synchronized void changeSignal(Signal newSignal) {
    currentSignal = newSignal;
    notifyObserver();
  }

  private void notifyObserver() {}

  public void setCurrentSignal(Signal currentSignal) {
    this.currentSignal = currentSignal;
  }

  public void setRedDuration(int redDuration) {
    this.redDuration = redDuration;
  }

  public void setYellowDuration(int yellowDuration) {
    this.yellowDuration = yellowDuration;
  }

  public void setGreenDuration(int greenDuration) {
    this.greenDuration = greenDuration;
  }

  public String getId() {
    return id;
  }

  public Signal getCurrentSignal() {
    return currentSignal;
  }

  public int getRedDuration() {
    return redDuration;
  }

  public int getYellowDuration() {
    return yellowDuration;
  }

  public int getGreenDuration() {
    return greenDuration;
  }
}
