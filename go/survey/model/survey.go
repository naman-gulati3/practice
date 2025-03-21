package model

import (
	"gorm.io/gorm"
)

type Survey struct {
	gorm.Model
	ID          uint       `json:"id" gorm:"primaryKey;autoIncrement:true"`
	User        User       `json:"user_id" gorm:"not null;foreignKey:UserID"`
	Title       string     `json:"title" gorm:"not null"`
	Description string     `json:"description"`
	Questions   []Question `json:"questions" gorm:"foreignKey:SurveyID"`
}

type SurveyResponse struct {
	Title       string `json:"title"`
	Description string `json:"description"`
}
