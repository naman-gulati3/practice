package com.practice.lld.traffic_light;

public class Main {

  public static void main(String[] args) {
    Road road1 = new Road("NH1", "Delhi - Meerut Expressway");
    Road road2 = new Road("NH2", "Delhi - Mumbai Expressway");
    Road road3 = new Road("NH3", "Surat - Mumbai Extension");

    TrafficLight tl1 = new TrafficLight("TL1", 50000, 5000, 30000);
    TrafficLight tl2 = new TrafficLight("TL2", 50000, 5000, 30000);
    TrafficLight tl3 = new TrafficLight("TL3", 50000, 5000, 30000);

    road1.setTrafficLight(tl1);
    road2.setTrafficLight(tl2);
    road3.setTrafficLight(tl3);

    TrafficController trafficController = TrafficController.getInstance();
    trafficController.addRoad(road1);
    trafficController.addRoad(road2);
    trafficController.addRoad(road3);

    trafficController.startTrafficControl();
  }
}
