package model

import "database/sql/driver"

type QuestionType string

const (
	STRING          QuestionType = "STRING"
	YESNO           QuestionType = "YESNO"
	MULTIPLE_CHOICE QuestionType = "MULTIPLE_CHOICE"
)

type Question struct {
	ID           uint         `json:"id" gorm:"primaryKey;autoIncrement:true"`
	Question     string       `json:"question" gorm:"not null"`
	SurveyID     uint         `json:"survey_id" gorm:"not null"`
	QuestionType QuestionType `json:"type" gorm:"not null;type:question_type"`
	Options      string       `json:"options"`
}

func (p *QuestionType) Scan(value interface{}) error {
	*p = QuestionType(value.([]byte))
	return nil
}

func (p QuestionType) Value() (driver.Value, error) {
	return string(p), nil
}
