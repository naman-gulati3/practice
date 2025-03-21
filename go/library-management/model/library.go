package model

import (
	"library-management/errors"
)

type Library struct {
	name           string
	bookCollection map[string]*BookAndQuantity
	members        map[string]*Member
}

func NewLibrary(name string) *Library {
	return &Library{
		name:           name,
		bookCollection: make(map[string]*BookAndQuantity),
		members:        make(map[string]*Member),
	}
}

func (l *Library) AddBook(book *Book) {
	_, exists := l.bookCollection[book.title]
	if !exists {
		l.bookCollection[book.title] = &BookAndQuantity{
			book:     book,
			quantity: intToPtr(1),
		}
		return
	}
	existingBookAndQuantity := l.bookCollection[book.title]
	existingBookAndQuantity.quantity = intToPtr(*existingBookAndQuantity.quantity + 1)
	l.bookCollection[book.title] = existingBookAndQuantity
}

func (l *Library) AddMember(name string, email string, phone string) (*Member, error) {
	_, exists := l.members[email]
	if exists {
		return nil, errors.ErrMemberAlreadyExists
	}
	l.members[email] = &Member{
		name:  name,
		email: email,
		phone: phone,
	}

	return l.members[email], nil
}

func intToPtr(i int) *int {
	return &i
}
