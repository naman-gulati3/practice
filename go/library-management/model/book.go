package model

import "time"

type Category string

var (
	FICTION_CATEGORY     = "FICTION"
	NON_FICTION_CATEGORY = "NON_FICTION"
)

type Book struct {
	title        string
	author       string
	serialNumber string
	publishedAt  time.Time
	category     Category
	isBorrowed   bool
}

func NewBook(title string, author string, serial string, publishedAt time.Time, category Category) *Book {
	return &Book{
		title:        title,
		author:       author,
		serialNumber: serial,
		publishedAt:  publishedAt,
		category:     category,
	}
}
