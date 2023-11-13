package org.ulpgc.dacd.control;

import org.ulpgc.dacd.model.WeatherData;

import java.io.IOException;

public interface WeatherProvider {
	WeatherData getWeatherData(double latitude, double longitude) throws IOException;
}
