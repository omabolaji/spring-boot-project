package com.famousbeejay.spring.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	
	private static int userCounter = 5;
	
	static {
		users.add(new User(1, "Bola", new Date()));
		users.add(new User(2, "Shade", new Date()));
		users.add(new User(3, "Kenny", new Date()));
		users.add(new User(4, "Funke", new Date()));
		users.add(new User(5, "Dami", new Date()));
	}
	
	//find all users
	public List<User> findAll() {
		return users;	
	}
	
	
	//save user
	public User save(User user) {
		if(user.getId() == 0) {
			user.setId(++userCounter);
		}
		users.add(user);
		return user;	
	}
	
	
	//find one user
	public User findOne(int id) {
		for(User user : users) {
			if(user.getId()== id) {
				return user;
			}
		}
		return null;
	}
	
	//update a user
//	 public static Shipwreck update(Long id, Shipwreck wreck) {
//		    wrecks.put(id, wreck);
//		    return wreck;
//		  }
	 public User update(int id, User user ) {
		 users.add(id, user);
		 
		 return user;
	 }
	
	//find one user and delete
		public User deleteById(int id) {
			Iterator<User> iterator = users.iterator();
			while(iterator.hasNext()) {
				User user = iterator.next();
				if(user.getId()== id) {
					iterator.remove();
					return user;
				}
			}
			return null;
		}
	
}
