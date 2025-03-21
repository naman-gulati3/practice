package errors

import "errors"

var (
	ErrInsufficientBalance = errors.New("insufficient account balance")
	ErrAccountAlreadyExist = errors.New("account already exists")
)
