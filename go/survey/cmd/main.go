package main

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/survey/config"
	"github.com/survey/database"
	"github.com/survey/handler"
)

func main() {
	r := gin.Default()
	r.GET("/ping", func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{
			"message": "pong",
		})
	})
	dbConfig := config.GetDBConfig()
	database.InitializeDB(dbConfig)
	handler.InitializeRoutes(&r.RouterGroup)
	r.Run()
}
