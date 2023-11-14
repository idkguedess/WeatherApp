package org.ulpgc.dacd.control;

import org.ulpgc.dacd.model.WeatherData;

import java.io.IOException;
import java.time.LocalDate;

public class WeatherController {
	private WeatherProvider weatherProvider;
	private WeatherStore weatherStore;

	public WeatherController(WeatherProvider weatherProvider, WeatherStore weatherStore) {
		this.weatherProvider = weatherProvider;
		this.weatherStore = weatherStore;
	}

	public void updateWeatherData(String island, double latitude, double longitude) {
		try {
			WeatherData weatherData = weatherProvider.getWeatherData(latitude, longitude);
			weatherStore.saveWeatherData(island, LocalDate.now(), weatherData);
			System.out.println("Datos meteorológicos actualizados correctamente.");
		} catch (IOException e) {
			System.err.println("Error al obtener los datos meteorológicos: " + e.getMessage());
		}
	}
}

