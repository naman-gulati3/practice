package model

type Card struct {
	Number       string
	CustomerName string
	ExpiryMonth  int
	ExpiryYear   int
	CVV          int
	IsActive     bool
	CardType     CardType
	Pin          int
}

type CardType string

var (
	CreditCard CardType = "CREDIT_CARD"
	DebitCard  CardType = "DEBIT_CARD"
)
