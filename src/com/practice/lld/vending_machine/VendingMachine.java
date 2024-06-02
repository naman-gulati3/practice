package com.practice.lld.vending_machine;

public class VendingMachine {
  private static VendingMachine instance;
  public Inventory inventory;
  private final VendingeMachineState idleState;
  private final VendingeMachineState readyState;
  private final VendingeMachineState dispenseState;
  private final VendingeMachineState returnState;
  private VendingeMachineState currentState;
  private Product selectedProduct;
  private double totalPayment;

  private VendingMachine() {
    inventory = new Inventory();
    idleState = new IdleVendingMachineState(this);
    readyState = new ReadyVendingMachineState(this);
    dispenseState = new DispenseVendingMachineState(this);
    returnState = new ReturnVendingMachineState(this);
    currentState = idleState;
    selectedProduct = null;
    totalPayment = 0.0;
  }

  public static synchronized VendingMachine getInstance() {
    if(instance == null) {
      instance = new VendingMachine();
    }
    return instance;
  }

  public void selectProduct(Product product) {
    currentState.selectProduct(product);
  }

  public void insertCoin(Coin coin) {
    currentState.insertCount(coin);
  }

  public void insertNote(Note note) {
    currentState.insertNote(note);
  }

  public void dispenseProduct() {
    currentState.dispenseProduct();
  }

  public void returnChange() {
    currentState.returnChange();
  }

  public VendingeMachineState getIdleState() {
    return idleState;
  }

  public VendingeMachineState getReadyState() {
    return readyState;
  }

  public VendingeMachineState getDispenseState() {
    return dispenseState;
  }

  public VendingeMachineState getReturnState() {
    return returnState;
  }

  public VendingeMachineState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(VendingeMachineState currentState) {
    this.currentState = currentState;
  }

  public Product getSelectedProduct() {
    return selectedProduct;
  }

  public void setSelectedProduct(Product selectedProduct) {
    this.selectedProduct = selectedProduct;
  }

  public double getTotalPayment() {
    return totalPayment;
  }

  public void setTotalPayment(double totalPayment) {
    this.totalPayment = totalPayment;
  }

  void addCoin(Coin coin) {
    totalPayment += coin.getValue();
  }

  void addNote(Note note) {
    totalPayment += note.getValue();
  }

  void resetPayment() {
    totalPayment = 0.0;
  }

  void resetSelectedProduct() {
    selectedProduct = null;
  }
}
