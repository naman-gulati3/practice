package handler

import (
	"net/http"
	"strconv"

	"github.com/gin-gonic/gin"
	"github.com/survey/dto"
	"github.com/survey/model"
	"github.com/survey/service"
)

func InitializeRoutes(router *gin.RouterGroup) {
	router.POST("/survey", CreateSurveyRoute)
	router.POST("/survey/:id/response", SubmitSurveyResponse)
}

func CreateSurveyRoute(c *gin.Context) {
	var survey model.Survey
	err := c.ShouldBindJSON(&survey)
	if err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}

	service.CreateSurvey(survey)

	c.JSON(http.StatusCreated, gin.H{"message": "Survey created successfully"})
}

func SubmitSurveyResponse(c *gin.Context) {
	surveryID := c.Param("id")
	if surveryID == "" {
		c.JSON(http.StatusBadRequest, gin.H{"message": "Survey ID is required"})
	}

	var responseDto dto.SurveyResponse
	err := c.ShouldBindJSON(&responseDto)
	if err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
	}

	intSurveyId, err := strconv.Atoi(surveryID)
	if err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
	}

	err = service.SubmitSurveyResponse(intSurveyId, responseDto)
	if err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
	}

	c.JSON(http.StatusCreated, gin.H{"message": "Survey response created successfully"})
}
