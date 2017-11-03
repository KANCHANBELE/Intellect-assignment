package com.java.springboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.java.springboot.model.User;



@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<User> findAllUsers() {
		return users;
	}
	
	public User findById(String id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String fName) {
		for(User user : users){
			if(user.getfName().equalsIgnoreCase(fName)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(String id) {
		
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(User user) {
		return findByName(user.getfName())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	@SuppressWarnings("deprecation")
	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User("1231","Sam","Sharma","sam.sharma@gmail.com",123456,new Date("30-Oct-1990"), true));
		users.add(new User("1232","Lisa","san","lisa.sharma@gmail.com",123456,new Date("30-Oct-1990"), true));
		users.add(new User("1233","Brijesh","Gupta","brijesh.sharma@gmail.com",123456,new Date("30-Oct-1990"), true));
		users.add(new User("1234","Karan","P","karan.sharma@gmail.com",123456,new Date("30-Oct-1990"), true));
		return users;
	}

}
