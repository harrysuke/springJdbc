package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;
import service.UserDao;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private final UserDao userDao;
	
	@Autowired
	public UserController(UserDao userDao) {
		this.userDao = userDao;
	}
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	@PostMapping("/login")
	public String loginUser(@ModelAttribute("user") User user, Model model) {
		userDao.login(user.getEmail(), user.getPassword());
		return "redirect:/product/list";
	}
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user, Model model) {
		userDao.register(user);
		return "redirect:/product/list";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/user/login";
	}

}
