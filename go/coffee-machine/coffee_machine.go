package model

import (
	"errors"
	"fmt"
	"sync"
)

type CoffeeMachine struct {
	inventory       *Inventory
	paymentService  PaymentService
	availableDrinks map[string]*Coffee
}

var (
	instance *CoffeeMachine
	once     sync.Once
)

func NewCoffeeMachine(inventory *Inventory, paymentService PaymentService) *CoffeeMachine {
	once.Do(func() {
		instance = &CoffeeMachine{
			inventory:       inventory,
			paymentService:  paymentService,
			availableDrinks: make(map[string]*Coffee),
		}
	})
	return instance
}

func (m *CoffeeMachine) AddDrink(coffee *Coffee) {
	m.availableDrinks[coffee.name] = coffee
}

func (m *CoffeeMachine) PrepareDrink(drinkName string, paymentTool PaymentTool) error {
	coffee, exists := m.availableDrinks[drinkName]
	if !exists {
		return errors.New("drink not available")
	}

	if err := m.inventory.HasSufficientIngredients(coffee); err != nil {
		return err
	}

	if err := m.paymentService.Execute(coffee.price, paymentTool); err != nil {
		return err
	}

	m.inventory.UseIngredients(coffee)
	return nil
}

func (m *CoffeeMachine) DisplayMenu() {
	fmt.Println("--- Menu --- ")
	for _, drink := range instance.availableDrinks {
		fmt.Printf("%s - %.2f\n", drink.name, drink.price)
	}
}

func (m *CoffeeMachine) AvailableDrinks() map[string]*Coffee {
	return m.availableDrinks
}
