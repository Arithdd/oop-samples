package com.di;

import java.sql.Connection;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

// Клас Forecasting
public class Forecasting {
    private List<Person> Meteorologs; // Агрегація: Forecasting використовує список Person
    private Forecast Forecast;      // Композиція: Forecasting володіє Forecast

    private ForecastService ForecastService;

    @Inject
    public void setForecastService(ForecastService ForecastService) {
        this.ForecastService = ForecastService;
    }

    @Inject
    public void setMeteorologs(List<Person> Meteorologs) {
        this.Meteorologs = Meteorologs;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ForecastingModule());

        // Створення екземплярів Forecasting (не Singleton)
        Forecasting Forecasting1 = injector.getInstance(Forecasting.class);
        Forecasting Forecasting2 = injector.getInstance(Forecasting.class);

        // Перевірка екземплярів Forecasting
        System.out.println("Forecasting1 == Forecasting2: " + 
            ((Forecasting1 == Forecasting2) ? 
            "Посилання на один і той самий екземпляр об'єкту класу Forecasting, тому що застосовано шаблон проектування 'Singleton'" : 
            "Посилання на різні екземпляри об'єктів класу Forecasting"));

        // Отримання екземпляра Connection
        Connection connection1 = injector.getInstance(Connection.class);
        Connection connection2 = injector.getInstance(Connection.class);

        // Перевірка екземплярів з'єднання
        System.out.println("connection1 == connection2: " + 
            ((connection1 == connection2) ? 
            "Посилання на один і той самий екземпляр об'єкту класу Connection, тому що застосовано шаблон проектування 'Singleton'" : 
            "Посилання на різні екземпляри об'єктів класу Connection"));

        Forecasting1.processForecasting("температура в день +2 в ночі -2, можливий дощ");
    }

    void processForecasting(String forecast) {
        for (Person Meteorolog : Meteorologs) {
            System.out.println("Запис прогнозу погоди від метеоролога " + Meteorolog.getName());

            
           

           
            Forecast = new Forecast(forecast, "2024-09-15");
            Forecast.displayForecastInfo();

            ForecastService.saveForecast(Forecast);

            System.out.println("прогноз погоди: " + forecast);

        }
    }
}