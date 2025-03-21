package model

import "errors"

type Inventory struct {
	Ingredients map[string]*IngredientAndQuantity
}

type IngredientAndQuantity struct {
	ingredient        *Ingredient
	inventoryQuantity int // quantity available in inventory
}

func NewInventory() *Inventory {
	return &Inventory{
		Ingredients: make(map[string]*IngredientAndQuantity),
	}
}

func (i *Inventory) FillInventory(ingredients ...*IngredientAndQuantity) {
	for _, ingredient := range ingredients {
		i.Ingredients[ingredient.ingredient.name] = ingredient
	}
}

func (i *Inventory) GetIngredient(name string) (*Ingredient, error) {
	ingredient, exists := i.Ingredients[name]
	if !exists {
		return nil, errors.New("ingredient not found")
	}
	return ingredient.ingredient, nil
}
func (i *Inventory) HasSufficientIngredients(coffee *Coffee) error {
	for ingredient, requiredQuantity := range coffee.recipe {
		inventoryIngredient, exists := i.Ingredients[ingredient.name]
		if !exists {
			return errors.New("ingredient " + ingredient.name + " not available")
		}
		if inventoryIngredient.inventoryQuantity < requiredQuantity {
			return errors.New("insufficient quantity for ingredient " + ingredient.name)
		}
	}
	return nil
}

func (i *Inventory) UseIngredients(coffee *Coffee) {
	for requiredIngredient, requiredQuantity := range coffee.recipe {
		inventoryIngredient := i.Ingredients[requiredIngredient.name]
		newQuantity := inventoryIngredient.inventoryQuantity - requiredQuantity
		inventoryIngredient.inventoryQuantity = newQuantity
	}
}
