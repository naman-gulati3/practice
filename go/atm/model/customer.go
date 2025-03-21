package model

type Customer struct {
	BankAccount *Account
	Name        string
	PhoneNumber string
	Email       string
	KycVerified bool
}

func NewCustomer(name string, phone string, email string) *Customer {
	return &Customer{
		Name:        name,
		PhoneNumber: phone,
		Email:       email,
		KycVerified: true,
	}
}
