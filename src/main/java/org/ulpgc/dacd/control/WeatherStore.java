package org.ulpgc.dacd.control;

import org.ulpgc.dacd.model.WeatherData;

import java.sql.*;
import java.time.LocalDate;

public class WeatherStore {
	private static final String DB_URL = "jdbc:sqlite:weather_data.db";

	public void saveWeatherData(String island, LocalDate date, WeatherData weatherData) {
		try (Connection connection = DriverManager.getConnection(DB_URL);
			 Statement statement = connection.createStatement()) {

			// Crea la tabla si no existe
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS \"" + island + "\" (" +
					"id INTEGER PRIMARY KEY AUTOINCREMENT," +
					"date DATE NOT NULL," +
					"temperature REAL NOT NULL," +
					"humidity INTEGER NOT NULL," +
					"wind_speed REAL NOT NULL," +
					"clouds_all INTEGER NOT NULL);");

			// Inserta los datos meteorológicos
			try (PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO \"" + island + "\" (date, temperature, humidity, wind_speed, clouds_all) " +
							"VALUES (?, ?, ?, ?, ?)")) {

				preparedStatement.setDate(1, java.sql.Date.valueOf(date));
				preparedStatement.setDouble(2, weatherData.getMain().getTemp());
				preparedStatement.setInt(3, weatherData.getMain().getHumidity());
				preparedStatement.setDouble(4, weatherData.getWind().getSpeed());
				preparedStatement.setInt(5, weatherData.getClouds().getAll());

				int rowsAffected = preparedStatement.executeUpdate();

				if (rowsAffected > 0) {
					System.out.println("Datos meteorológicos guardados correctamente para " + island);
				} else {
					System.err.println("Error al insertar datos meteorológicos para " + island + ". No se afectaron filas.");
				}
			}

		} catch (SQLException e) {
			System.err.println("Error al ejecutar la consulta SQL para la tabla " + island + ": " + e.getMessage());
			e.printStackTrace();
		}
	}
}
