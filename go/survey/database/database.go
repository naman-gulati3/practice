package database

import (
	"github.com/survey/config"
	"github.com/survey/model"
	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

var (
	db *gorm.DB
)

func GetDB() *gorm.DB {
	return db
}

func InitializeDB(dbConfig *config.DBConfig) {
	var err error
	db, err = gorm.Open(postgres.Open(dbConfig.GetDSN()))
	if err != nil {
		panic("Failed to connect to database")
	}
	db.Exec("CREATE TYPE question_type AS ENUM ('STRING', 'YESNO', 'MULTIPLE_CHOICE')")
	db.AutoMigrate(&model.User{})
	db.AutoMigrate(&model.Question{})
	db.AutoMigrate(&model.Survey{})
	db.AutoMigrate(&model.Answer{})
	db.Exec("CREATE UNIQUE INDEX idx_user_question ON answers(user_id, question_id)")
}
