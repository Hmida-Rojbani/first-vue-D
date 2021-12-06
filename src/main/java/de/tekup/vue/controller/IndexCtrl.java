package de.tekup.vue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.vue.models.UserForm;
import de.tekup.vue.models.WelcomeMsg;
import de.tekup.vue.repos.UserDB;

@Controller
public class IndexCtrl {
	
	@GetMapping({"/","/index"})
	public String getIndex(Model model) {
		WelcomeMsg welcome = new WelcomeMsg("Welcome GLSI-D", "Welcome Mehrez spec");
		model.addAttribute("welcomeMsg", welcome);
		return "index";
	}
	
	@GetMapping("/add/user")
	public String getAddUSer(Model model) {
		model.addAttribute("user", new UserForm());
		return "user/add-user";
	}
	
	@PostMapping("/add/user")
	public String postAddUSer(@ModelAttribute("user") UserForm user) {
		System.out.println(user);
		UserDB.addUser(user);
		System.out.println(UserDB.getUsers());
		return "redirect:/show/users";
	}
	
	@GetMapping("/show/users")
	public String getAllUSer(Model model) {
		model.addAttribute("listUsers", UserDB.getUsers());
		return "user/show-users";
	}

}
