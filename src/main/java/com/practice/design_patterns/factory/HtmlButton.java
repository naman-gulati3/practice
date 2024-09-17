package com.practice.design_patterns.factory;

public class HtmlButton implements Button {

  @Override
  public void render() {
    System.out.println("<button> Test Button </button>");
    onClick();
  }

  @Override
  public void onClick() {
    System.out.println("Click event!");
  }
}
