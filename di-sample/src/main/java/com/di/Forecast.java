package com.di;

// Клас Forecast
class Forecast {
    private String forecast;
    private String forecastDate;

    // Конструктор
    public Forecast(String forecast, String forecastDate) {
        this.forecast = forecast;
        this.forecastDate = forecastDate;
    }

    // Геттери
    public String getforecast() {
        return forecast;
    }

    public String getforecastDate() {
        return forecastDate;
    }

    // Метод для відображення деталей зарплати
    public void displayForecastInfo() {
        System.out.println("Forecast - forecast: " + forecast + ", Date: " + forecastDate);
    }
}