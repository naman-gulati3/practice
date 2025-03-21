package service

import (
	"library-management/model"
	"time"
)

type LibraryService interface {
	CreateLibrary(name string) *model.Library
	CreateBook(name string, author string, serial string, publishedAt time.Time, category model.Category) *model.Book
	AddBook(l *model.Library, book *model.Book)
	RegisterMember(library *model.Library, name string, email string, phoneNumber string) (*model.Member, error)
	GetBooksByFilter(title string, author string) []*model.Book
	BorrowBook(l *model.Library, book *model.Book, member *model.Member) error
	ReturnBook(l *model.Library, book *model.Book)
}

type library struct {
}

func NewLibraryService() LibraryService {
	return &library{}
}

func (l *library) CreateLibrary(name string) *model.Library {
	return model.NewLibrary(name)
}

func (l *library) CreateBook(name string, author string, serial string, publishedAt time.Time, category model.Category) *model.Book {
	return model.NewBook(name, author, serial, publishedAt, category)
}

func (l *library) AddBook(library *model.Library, book *model.Book) {
	library.AddBook(book)
}

func (l *library) RegisterMember(library *model.Library, name string, email string, phoneNumber string) (*model.Member, error) {
	return library.AddMember(name, email, phoneNumber)
}

func (l *library) GetBooksByFilter(title string, author string) []*model.Book {
	return nil
}

func (l *library) BorrowBook(library *model.Library, book *model.Book, member *model.Member) error {
	return nil
}

func (l *library) ReturnBook(library *model.Library, book *model.Book) {

}
