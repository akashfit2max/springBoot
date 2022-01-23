package com.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.web.dao.UserRepository;
import com.springboot.web.entities.User;

@Controller
public class TestController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/run")
	@ResponseBody
	public String run() {
		return "my first spring boot project";
	}

	@RequestMapping("/")
	public String home() {
		System.out.println("insi" + "de home page");
		return "home";
	}

	@ResponseBody
	@RequestMapping("/db")
	public String db() {
		User user = new User();
		user.setName("Akash");
		user.setCity("chennai");
		user.setStatus("busy");

		User newUser = userRepository.save(user);
		System.out.println(newUser);
		return "user created";
	}

	@ResponseBody
	@RequestMapping("/dbop")
	public String dbopeartions() {

//		User user2 = new User();
//		user2.setName("Ashish");
//		user2.setCity("chennai");
//		user2.setStatus("offline");
//
//		User user3 = new User();
//		user3.setName("Mamata");
//		user3.setCity("kanpur");
//		user3.setStatus("unknown");

//		single user save
//		User newUser = userRepository.save(user);

//	    saving all instances
//		List<User> users = List.of(user3, user2);
//		System.out.println(users);
//		Iterable<User> allUsers = userRepository.saveAll(users);
//
//		allUsers.forEach(user4 -> {
//			System.out.println(user4);
//		});

//		update the user of id 9
//		Optional<User> optional = userRepository.findById(9);
//		User user = optional.get();
//		System.out.println(user);
//
//		user.setName("satyam");
//		User save = userRepository.save(user);
//		System.out.println(save);

//		find by id
//		Optional<User> optional = userRepository.findById(9);
//		User user = optional.get();

//		get all data
//		List<User> manyUsers = userRepository.findAll();
//		manyUsers.forEach(user -> System.out.println(user));

//		deleting a paticular data
//		userRepository.deleteById(9);
//		System.out.println("deleted");

//		deleting all
//		List<User> all = userRepository.findAll();
//		all.forEach(user -> System.out.println(user));
//
//		userRepository.deleteAll(all);

//		custome finder method
//		List<User> findByName = userRepository.findByName("mamata");

//		List<User> finUsers = userRepository.findByNameAndCity("akash", "chennai");
//		finUsers.forEach(e -> System.out.println(e));

//		custome queries
		List<User> list = userRepository.getAllUsers();
		list.forEach(e -> System.out.println(e));

		System.out.println("*******______________***********");
		List<User> userByName = userRepository.getUserByName("akash", "chennai");
		userByName.forEach(e -> System.out.println(e));

		System.out.println("_______________________________________");
//		firing natice query
		userRepository.getUsers("varsha").forEach(e -> System.out.println(e));

		return "completed the coding";

	}

}
