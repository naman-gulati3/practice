package com.practice.design_patterns.factory;

public class WindowDialog extends Dialog {

  @Override
  public Button createButton() {
    return new WindowButton();
  }
}
