package model

type Member struct {
	name          string
	phone         string
	email         string
	address       string
	borrowedBooks []*Borrow
}

// func NewMember() *Member {

// }
