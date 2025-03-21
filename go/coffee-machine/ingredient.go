package model

type Ingredient struct {
	name string
	cost float64
}

func NewIngredient(name string, cost float64) *Ingredient {
	return &Ingredient{
		name: name,
		cost: cost,
	}
}

func (i *Ingredient) Name() string {
	return i.name
}

func (i *Ingredient) Cost() float64 {
	return i.cost
}
