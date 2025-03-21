package model

import "time"

type Borrow struct {
	book               *Book
	issuedAt           time.Time
	expectedReturnDate time.Time
}

func NewBorrow(book *Book, issuedAt time.Time, expectedReturnDate time.Time) *Borrow {
	return &Borrow{
		book:               book,
		issuedAt:           issuedAt,
		expectedReturnDate: expectedReturnDate,
	}
}
