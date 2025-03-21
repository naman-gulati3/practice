package model

type WithdrawlTransaction struct {
	BaseTransaction
}

func (t *WithdrawlTransaction) Execute() error {
	return t.Account.Debit(t.Amount)
}
