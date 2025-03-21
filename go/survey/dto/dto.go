package dto

type SurveyResponse struct {
	Responses []Response `json:"responses"`
}

type Response struct {
	QuestionID uint   `json:"question_id"`
	Answer     string `json:"answer"`
	UserID     int    `json:"user_id"`
}
