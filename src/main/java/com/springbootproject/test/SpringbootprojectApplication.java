package com.springbootproject.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springbootproject.test.dao.UserRepository;
import com.springbootproject.test.entities.User;

@SpringBootApplication
public class SpringbootprojectApplication {
 

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringbootprojectApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		//<=========================================================>
		//For first user
		
		
		/*
		 * User user = new User();
		 * 
		 * user.setName("Umair"); user.setCity("Lucknow");
		 * user.setStatus("I am a java programmer");
		 * 
		 * User save = userRepository.save(user); System.out.println(save);
		 */
		 
		
		//<=========================================================>
		//Create Obj for User and Save ALL User at a same time 
		
		/*
		 * User userA = new User();
		 * 
		 * userA.setName("Umair"); userA.setCity("Lucknow");
		 * userA.setStatus("I am a java programmer");
		 * 
		 * User userB = new User();
		 * 
		 * userB.setName("Arshad"); userB.setCity("kanpur");
		 * userB.setStatus("I am a python programmer");
		 * 
		 * List<User> users = List.of(userA,userB);
		 * 
		 * //Save multiple obj Iterable<User> result = userRepository.saveAll(users);
		 * 
		 * result.forEach(user->{ System.out.println(user); });
		 */
		
		//<=========================================================>
		
		//Update the user of Id 6
		/*
		 * Optional<User> optional = userRepository.findById(6);
		 * 
		 * User u = optional.get();
		 * 
		 * u.setName("Rohan Khan"); User resultUser = userRepository.save(u);
		 * System.out.println(resultUser);
		 */
		
		//<=========================================================>
		
		//How to get the Data
		//Iterable<User> itr = userRepository.findAll();
		/*
		 * Iterator<User> iterator = itr.iterator();
		 * 
		 * while (iterator.hasNext()) { User user = (User) iterator.next();
		 * System.out.println(user);
		 * 
		 * }
		 */
		
		/*
		 * itr.forEach(new Consumer<User>() {
		 * 
		 * @Override public void accept(User t) { // TODO Auto-generated method stub
		 * System.out.println(t); }
		 * 
		 * });
		 */
		
		//itr.forEach(user->{System.out.println(user);});
		
		//<=========================================================>
		
		//Delete the user Element (It has 4 properties of delete way)
		/*
		 * userRepository.deleteById(6); System.out.println("Delete");
		 */
		 
		//For all users of DB
		/*
		 * Iterable<User> allUsers = userRepository.findAll();
		 * allUsers.forEach(user->System.out.println(user));
		 * 
		 * userRepository.deleteAll(allUsers);
		 */
		
		//Custom finder method / Derived Mtdh <==== 1 =====>
		/*
		 * List<User> users = userRepository.findByName("Umair");
		 * users.forEach(e->System.out.println(e));
		 */
		
		//<==== 2 =====>
		/*
		 * List<User> u2 = userRepository.findByNameAndCity("Umair", "Lucknow");
		 * u2.forEach(e->System.out.println(e));
		 */
		
		//<==== 3 =====>
		/*
		 * List<User> allUser = userRepository.getAllUser();
		 * allUser.forEach(e->System.out.println(e));
		 */
		
		//<==== 4 =====>
		/*
		 * List<User> allUser = userRepository.getAllUserByName("Rohan");
		 * allUser.forEach(e->System.out.println(e));
		 */
		
		//<==== 5 =====>
		/*
		 * List<User> allUser =
		 * userRepository.getAllUserByNameAndCity("Rohan","kanpur");
		 * allUser.forEach(e->System.out.println(e));
		 */
		
		//<==== 6 =====>
		//userRepository.getUsers().forEach(e->System.out.println(e));
		
		
		 
		
	}

}
 