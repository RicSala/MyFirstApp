package com.imprender.dropwizardsample.model;

import java.util.Date;

public class Transaction {
	private User giver;
	private User receiver;
	private int amount;
	private Date date;
	private boolean verified;

	public Transaction(User giver, User receiver, int amount) {
		this.giver = giver;
		this.receiver = receiver;
		this.amount = amount;
		this.date = new Date();
		verified = false;
	}

	public User getGiver() {
		return giver;
	}

	public User getReceiver() {
		return receiver;
	}

	public int getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	public boolean isVerified() {
		return verified;
	}
}
