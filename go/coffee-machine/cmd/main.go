package main

import (
	model "coffee_machine"
)

func main() {
	inventory := model.NewInventory()
	paymentService := model.NewPaymentService()
	machine := model.NewCoffeeMachine(inventory, paymentService)

	milk := model.NewIngredient("milk", 0.5)
	coffee := model.NewIngredient("coffee", 1.0)
	water := model.NewIngredient("water", 0.1)

	// inventory.FillInventory(milk, coffee, water)
	// Create a coffee recipe
	latte := model.NewCoffee("latte", *milk, *coffee, *water, *coffee)
	espresso := model.NewCoffee("espresso", *coffee, *coffee, *water)
	americano := model.NewCoffee("americano", *coffee, *water, *water)

	// Add drink to machine
	machine.AddDrink(latte)
	machine.AddDrink(espresso)
	machine.AddDrink(americano)

	machine.DisplayMenu()

	// Prepare a drink
	err := machine.PrepareDrink("latte", model.CreditCard)
	if err != nil {
		panic(err)
	}
}
