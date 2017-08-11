package com.imprender.dropwizardsample.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class User implements Serializable {
	private String name;
	private String dateOfBirth;
	private int funds;
	private static int index = 0;
	private final int ID;
	private String job;
	private String imagePath;

	public User(String name, String dateOfBirth, int funds, String job, String imagePath) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.funds = funds;
		this.ID = index;
		this.job = job;
		this.imagePath = imagePath;
		index++;
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

	@Override
	public String toString() {
		return this.name;
	}


	public String getNameLink() {
		return "<a href=\"http://localhost:8080/users/" + this.ID + "\">" + this.getName() + "</a>";
	}

	public static void save(List<User> users) {
		try (
				FileOutputStream fos = new FileOutputStream("user.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
		) {
			oos.writeObject(users);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static List<User> load() {
		List<User> users = new ArrayList<>();
		try (
				FileInputStream fis = new FileInputStream("user.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			users = (List<User>) ois.readObject();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}

	public String getJob() {
		return this.job;
	}

	public int getID() {
		return ID;
	}

	public String getImagePath() {
		return imagePath;
	}
}
