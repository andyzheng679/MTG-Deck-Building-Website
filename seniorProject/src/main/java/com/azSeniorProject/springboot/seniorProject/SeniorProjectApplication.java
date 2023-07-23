package com.azSeniorProject.springboot.seniorProject;

import com.azSeniorProject.springboot.seniorProject.dao.UserDAO;
import com.azSeniorProject.springboot.seniorProject.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.azSeniorProject.springboot.seniorProject")
public class SeniorProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeniorProjectApplication.class, args);
	}

	/*
	@Bean
	public CommandLineRunner commandLineRunner(UserDAO userDAO) {

		return runner -> {
			//createUser(userDAO);

			deleteUser(userDAO);

			//deleteAllUsers(userDAO);


		};
	}
	*/

	private void deleteAllUsers(UserDAO userDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = userDAO.deleteAll();
		System.out.println("Number of Deleted users: " + numRowsDeleted);
	}

	private void deleteUser(UserDAO userDAO) {

		int userID = 5;
		System.out.println("Deleting student id: " + userID);
		userDAO.delete(userID);
	}


	private void createUser(UserDAO userDAO) {

		// create the user object
		System.out.println("Creating new user object ...");
		User tempUser = new User("Andy", "Zheng", "andyzheng7@yahoo.com", "Testing123");

		// save the user object
		System.out.println("Saving....");
		userDAO.save(tempUser);

		// display id of the saved user
		System.out.println("Saved User. Generated id: " + tempUser.getId());
	}
}
