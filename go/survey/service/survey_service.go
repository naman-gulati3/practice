package service

import (
	"fmt"

	"github.com/survey/dto"
	"github.com/survey/model"
	"github.com/survey/repository"
)

type SurveyService interface {
	CreateSurvey(survey model.Survey)
	SubmitSurveyResponse(surveyID uint, response dto.SurveyResponse)
}

func CreateSurvey(survey model.Survey) {
	repository.CreateSurvey(survey)
}

func SubmitSurveyResponse(surveyId int, surveyResponse dto.SurveyResponse) error {
	survey, err := repository.GetSurveyByID(surveyId)
	if err != nil {
		return err
	}

	if survey == nil {
		return fmt.Errorf("survey with id %d not found", surveyId)
	}

	answers := make([]model.Answer, len(surveyResponse.Responses))

	for i, response := range surveyResponse.Responses {
		answers[i] = model.Answer{
			UserID:     int64(response.UserID),
			QuestionID: response.QuestionID,
			Answer:     response.Answer,
		}
		
	}

	return repository.SubmitSurveyResponse(survey.ID, answers)
}
