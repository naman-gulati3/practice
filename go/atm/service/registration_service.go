package service

import (
	"atm/model"
	"atm/repository"
)

type RegistrationService interface {
	CreateBank(name string, branchCode string) *model.Bank
	CreateBankAccount(bank *model.Bank, customerName string, customerEmail string, customerPhone string) (*model.Account, error)
	CreateAtm(initialBalance float64) (*model.Atm, error)
	IssueCard(cardType model.CardType, customerName string) (*model.Card, error)
	Deposit(bank *model.Bank, cardNum string, pin int, amount float64) (float64, error)
	Withdraw(bank *model.Bank, cardNum string, pin int, amount float64) (float64, error)
}

type service struct {
	repo repository.Repository
}

func NewRegistrationService(repo repository.Repository) RegistrationService {
	return &service{repo: repo}
}

func (s *service) CreateBank(name string, branchCode string) *model.Bank {
	return s.repo.CreateBank(name, branchCode)
}

func (s *service) CreateAtm(initialBalance float64) (*model.Atm, error) {
	return s.repo.CreateAtm(initialBalance)
}

func (s *service) CreateBankAccount(bank *model.Bank, customerName string, customerEmail string, customerPhone string) (*model.Account, error) {
	return bank.CreateAccount(customerName, customerEmail, customerPhone)
}

func (s *service) IssueCard(cardType model.CardType, customerName string) (*model.Card, error) {
	return nil, nil
}

func (s *service) Deposit(bank *model.Bank, cardNum string, pin int, amount float64) (float64, error) {
	return 0, nil
}

func (s *service) Withdraw(bank *model.Bank, cardNum string, pin int, amount float64) (float64, error) {
	return 0, nil
}
