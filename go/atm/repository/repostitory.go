package repository

import "atm/model"

type Repository interface {
	CreateBank(name string, branchCode string) *model.Bank
	CreateAtm(initialBalance float64) (*model.Atm, error)
	// CreateBankAccount(customer model.Customer) (*model.Account, error)
}

type repo struct {
	Banks map[string]*model.Bank
	Atm   map[string]*model.Atm
}

func NewRepository() Repository {
	return &repo{
		Banks: make(map[string]*model.Bank),
		Atm:   make(map[string]*model.Atm),
	}
}

func (r *repo) CreateBank(name string, branchCode string) *model.Bank {
	bank := model.Bank{
		Name:       name,
		BranchCode: branchCode,
		Accounts:   make(map[string]*model.Account),
	}

	r.Banks[name] = &bank

	return &bank
}

func (r *repo) CreateAtm(initialBalance float64) (*model.Atm, error) {
	atm := model.Atm{
		Latitude:  0.0,
		Longitude: 0.0,
		Code:      "123",
		Bank:      "HDFC",
		Balance:   initialBalance,
	}

	r.Atm["123"] = &atm

	return &atm, nil
}
