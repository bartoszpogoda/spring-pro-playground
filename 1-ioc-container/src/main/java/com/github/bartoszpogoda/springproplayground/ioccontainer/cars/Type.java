package com.github.bartoszpogoda.springproplayground.ioccontainer.cars;

public enum Type {
	FORD_MUSTANG("Ford Mustang"), FERRARI_CALIFORNIA("Ferrari California");

	private String friendlyName;

	private Type(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

}
