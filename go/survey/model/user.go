package model

type User struct {
	ID    int64  `json:"id" gorm:"primaryKey;autoIncrement:true"`
	Name  string `json:"name" gorm:"not null"`
	Email string `json:"email" gorm:"not null"`
}
