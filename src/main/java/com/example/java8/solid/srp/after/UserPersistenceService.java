package com.example.java8.solid.srp.after;

public class UserPersistenceService {

	private Store store = new Store();

	public void saveUser(User user) {
		store.store(user);
	}
}

