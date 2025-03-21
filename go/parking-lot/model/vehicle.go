package model

type Vehicle struct {
	ID                int    `json:"id"`
	RegistationNumber string `json:"registration_number"`
	Color             string `json:"color"`
}
