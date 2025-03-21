package model

type Answer struct {
	ID         uint   `json:"id" gorm:"primaryKey;autoIncrement:true"`
	Answer     string `json:"answer" gorm:"not null"`
	QuestionID uint   `json:"question_id" gorm:"not null"`
	Version    *int64 `json:"version" gorm:"not null; default:1"`
	UserID     int64  `json:"user_id" gorm:"not null"`
}
