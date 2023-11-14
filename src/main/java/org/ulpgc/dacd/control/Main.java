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
				weatherController.updateWeatherData("Gran Canaria", 28.1288694, -15.4349015);
			}
		}, 0, 6 * 60 * 60 * 1000);
	}
}
