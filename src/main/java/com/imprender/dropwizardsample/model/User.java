package com.imprender.dropwizardsample.model;

public class User {
	private String name;
	private String dateOfBirth;
	private int funds;

	public User(String name, String dateOfBirth, int funds) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.funds = funds;
	}

	public String getName() {
		return name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public int getFunds() {
		return funds;
	}


}
