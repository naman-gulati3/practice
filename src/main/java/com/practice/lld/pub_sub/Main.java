package com.practice.lld.pub_sub;


public class Main {

  public static void main(String[] args) {
    Topic<String, String> topic = new Topic<>("click-events");

    Publisher<String, String> publisher = new Publisher<>(topic);
    publisher.publish(new Message<>("user1", "clicked_home_page_event"));

    Consumer<String, String> consumer1 = new Consumer<>();
    consumer1.subscribe(topic);
    Consumer<String, String> consumer2 = new Consumer<>();
    consumer2.subscribe(topic);

    consumer1.poll();
    consumer2.poll();
  }
}
