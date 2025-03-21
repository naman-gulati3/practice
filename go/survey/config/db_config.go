package config

import (
	"os"
	"strconv"
)

type DBConfig struct {
	Host     string
	Port     int
	Password string
	User     string
	Database string
}

func GetDBConfig() *DBConfig {
	return &DBConfig{
		Host:     os.Getenv("DB_HOST"),
		Port:     5432,
		Password: os.Getenv("DB_PASSWORD"),
		User:     os.Getenv("DB_USER"),
		Database: os.Getenv("DB_NAME"),
	}
}

func (dbConfig *DBConfig) GetDSN() string {
	return "host=" + dbConfig.Host + " port=" + strconv.Itoa(dbConfig.Port) + " user=" + dbConfig.User + " dbname=" + dbConfig.Database + " password=" + dbConfig.Password + " sslmode=disable"
}
