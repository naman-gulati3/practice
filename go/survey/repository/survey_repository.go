package repository

import (
	"github.com/survey/database"
	"github.com/survey/model"
)

func CreateSurvey(survey model.Survey) {
	db := database.GetDB()

	db.Table("surveys").Create(&survey)
}

func GetSurveyByID(id int) (*model.Survey, error) {
	db := database.GetDB()

	var survey *model.Survey

	db.Find(&survey, id)

	if db.Error != nil {
		return nil, db.Error
	}

	return survey, nil
}

func GetUserResponse(userID int, questionID int) (*model.Answer, error) {
	db := database.GetDB()

	var answer *model.Answer

	r := db.Where("user_id = ? AND question_id = ?", userID, questionID).First(&answer)

	if db.Error != nil {
		return nil, db.Error
	}

	if r.RowsAffected == 0 {
		return nil, nil
	}

	return answer, nil
}

func SubmitSurveyResponse(surveryID uint, answers []model.Answer) error {
	db := database.GetDB()
	for _, ans := range answers {
		anwerFromDb, _ := GetUserResponse(int(ans.UserID), int(ans.QuestionID))
		if anwerFromDb != nil {
			newVersion := *anwerFromDb.Version + 1

			db.Table("answers").Where("id = ?", anwerFromDb.ID).Update("version", newVersion)
		} else {
			db.Create(&ans)
		}
	}
	return nil
}
