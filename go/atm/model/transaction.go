package model

type Transaction interface {
	Execute() error
}

type BaseTransaction struct {
	Transaction string
	Account     *Account
	Amount      float64
}
