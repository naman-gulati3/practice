package model

import (
	"atm/errors"
	"time"
)

type Account struct {
	Number    string
	Ifsc      string
	CreatedAt time.Time
	Cards     map[string]Card
	Balance   float64
}

func (a *Account) Debit(amount float64) error {
	if a.Balance < amount {
		return errors.ErrInsufficientBalance
	}
	a.Balance -= amount
	return nil
}

func (a *Account) Credit(amount float64) error {
	a.Balance += amount
	return nil
}

func NewAccount(number string, ifsc string, createdAt time.Time) *Account {
	return &Account{
		Number:    number,
		Ifsc:      ifsc,
		CreatedAt: createdAt,
	}
}
