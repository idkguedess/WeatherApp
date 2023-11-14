package org.ulpgc.dacd.control;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
	public static void main(String[] args) {
		WeatherProvider weatherProvider = new OpenWeatherMapProvider();
		WeatherStore weatherStore = new WeatherStore();
		WeatherController weatherController = new WeatherController(weatherProvider, weatherStore);

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				weatherController.updateWeatherData("Gran Canaria", 27.9580004, -15.6062305376665);
			}
		}, 0, 6 * 60 * 60 * 1000);
	}
}
