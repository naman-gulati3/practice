package model

import (
	"atm/errors"
	"time"

	"github.com/google/uuid"
)

type Bank struct {
	Name       string
	BranchCode string
	Accounts   map[string]*Account
}

func (b *Bank) CreateAccount(customerName string, customerEmail string, customerPhone string) (*Account, error) {
	customer := NewCustomer(customerName, customerEmail, customerPhone)
	account := NewAccount(uuid.NewString(), "HDFC012", time.Now())
	customer.BankAccount = account
	if _, exists := b.Accounts[account.Number]; exists {
		return nil, errors.ErrAccountAlreadyExist
	}
	b.Accounts[account.Number] = account
	return account, nil
}
