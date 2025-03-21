package model

import (
	"fmt"
	"time"
)

type PaymentTool string

var (
	CreditCard PaymentTool = "credit_card"
	DebitCard  PaymentTool = "debit_card"
	Upi        PaymentTool = "upi"
	Cash       PaymentTool = "cash"
)

type PaymentService interface {
	Execute(amount float64, paymentTool PaymentTool) error
}

type Payment struct {
	amount      float64
	paymentTool PaymentTool
	paidAt      time.Time
}

func NewPayment(amount float64, tool PaymentTool) *Payment {
	return &Payment{
		amount:      amount,
		paymentTool: tool,
		paidAt:      time.Now(),
	}
}

type service struct {
}

func NewPaymentService() PaymentService {
	return &service{}
}

func (s *service) Execute(amount float64, paymentTool PaymentTool) error {
	fmt.Printf("Payment for amount %.2f processed successfully\n", amount)
	return nil
}
