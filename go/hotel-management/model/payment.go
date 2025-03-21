package model

type PaymentMode string

var (
	CREDIT_CARD PaymentMode = "CREDIT_CARD"
	CASH        PaymentMode = "CASH"
)

type Payment struct {
	Amount      float64
	Currency    string
	PaymentMode PaymentMode
}
