package model

type Address struct {
	ID        int     `json:"id"`
	Latitude  float64 `json:"latitude"`
	Longitude float64 `json:"longitude"`
	Country   string  `json:"country"`
	City      string  `json:"city"`
	ZipCode   string  `json:"zip_code"`
	Street    string  `json:"street"`
}
