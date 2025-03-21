package model

type Guest struct {
	Name string
}

func NewGuest(name string) *Guest {
	return &Guest{
		Name: name,
	}
}
