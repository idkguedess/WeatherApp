package org.ulpgc.dacd.model;

public class Location {
	private final int latitude;
	private final int longitude;

	private final String island;

	public Location(int latitude, int longitude, String island){
		this.latitude = latitude;
		this.longitude = longitude;
		this.island = island;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public String getIsland() {
		return island;
	}
}
