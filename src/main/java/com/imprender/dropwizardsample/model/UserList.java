package com.imprender.dropwizardsample.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserList implements Serializable{
	private List<User> usersList;

	public UserList() {
		 usersList = new ArrayList<>();
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void add(User user) {
		usersList.add(user);
	}

	public UserList match(String query) {
		UserList results = new UserList();

		for (User userIterator : usersList) {
			if (userIterator.getName().equals(query)) {
				results.add(userIterator);
			}
		}

		return results;
	}

	public int size() {
		return usersList.size();
	}

	public User get(int id) {
		return usersList.get(id);
	}

	public static void save(UserList users) {
		try (
				FileOutputStream fos = new FileOutputStream("user.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
		) {
			oos.writeObject(users);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static UserList load() {
		UserList users = new UserList();
		try (
				FileInputStream fis = new FileInputStream("user.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			users = (UserList) ois.readObject();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}

}
