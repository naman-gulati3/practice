package model

type Coffee struct {
	recipe map[*Ingredient]int
	name   string
	price  float64
}

func NewCoffee(name string, ingredients ...Ingredient) *Coffee {
	price := 0.0
	for _, ingredient := range ingredients {
		price += ingredient.cost
	}

	return &Coffee{
		recipe: make(map[*Ingredient]int),
		name:   name,
		price:  price,
	}
}

func (c *Coffee) Name() string {
	return c.name
}

func (c *Coffee) Price() float64 {
	return c.price
}

func (c *Coffee) Recipe() map[*Ingredient]int {
	return c.recipe
}
