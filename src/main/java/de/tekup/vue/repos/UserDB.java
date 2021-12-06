package de.tekup.vue.repos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import de.tekup.vue.models.UserForm;
import lombok.Getter;

@Repository
public class UserDB {
	
	@Getter private static List<UserForm> users;
	
	
	static{
		users = new ArrayList<>();
		users.add(new UserForm(1,"user1", "user1", LocalDate.parse("1999-09-08"), "user1@gmail.com"));
		users.add(new UserForm(2,"user2", "user2", LocalDate.parse("2000-09-08"), "user2@gmail.com"));
	}
	
	public static void addUser(UserForm user) {
		if(user.getId()==0)
			user.setId(users.size()+1);
		if(user.getId()!=0)
			users.removeIf(u->u.getId()==user.getId());
		users.add(user);
	}
	
	public static void deleteUser(int id) {
		users.removeIf(user-> user.getId()==id);
	}
	
	public static UserForm getUser(int id) {
		return users.stream()
		.filter(user-> user.getId()==id)
		.findFirst().get();
	}
	

}
