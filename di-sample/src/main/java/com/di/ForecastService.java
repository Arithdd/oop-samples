package com.di;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.google.inject.Inject;

/**
 * Клас ForecastService відповідає за збереження об'єктів Forecast у базі даних.
 * Використовує ін'єкцію залежностей для отримання з'єднання з базою даних.
 */
/**
 * Сервіс для обробки платежів.
 */
public class ForecastService {
    private final Connection connection;

    /**
     * Конструктор з впровадженням залежності від драйвера бази даних.
     *
     * @param connection з'єднання з базою даних
     */
    @Inject
    public ForecastService(Connection connection) {
        this.connection = connection;
    }

    protected Connection getConnection() {
        return connection;
    }

    /**
     * Метод для збереження об'єкта Forecast в базі даних.
     * 
     * Цей метод приймає об'єкт Forecast, створює SQL-запит для вставки даних
     * про зарплату в базу даних і виконує цей запит.
     *
     * @param Forecast об'єкт Forecast, який містить дані про зарплату
     * @throws RuntimeException якщо виникає помилка під час збереження даних
     */
    public void saveForecast(Forecast Forecast) {
        String sql = "INSERT INTO Forecasts (forecast, forecast_date) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, Forecast.getforecast());
            statement.setString(2, Forecast.getforecastDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save Forecast", e);
        }
    }
}