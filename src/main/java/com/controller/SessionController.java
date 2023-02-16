package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.dao.UserDao;
import com.dto.LoginDto;
import com.service.TokenGenerator;

@Controller
public class SessionController {

	@Autowired
	UserDao userdao;
	
	@Autowired
	TokenGenerator tokenGenerator;

	@GetMapping("/signup")
	public String signup() {
		System.out.println("signup()");
		return "Signup";
	}

	@PostMapping("/saveuser")
	public String saveuser(UserBean user) {
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());

		System.out.println(user.isIsdelete());

		userdao.insertUser(user);
		return "Home";
	}

	@GetMapping("/listusers")
	public String listUsers(Model model) {

		List<UserBean> users = userdao.getAllUsers();
		model.addAttribute("users", users);
		return "ListUsers";
	}

	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("userId") int userId) {

		userdao.deleteUser(userId);

		return "redirect:/listusers";
	}

	@GetMapping("/edituser")
	public String editUser(@RequestParam("userId") int userId, Model model) {
		UserBean user = userdao.getUserByUserId(userId);
		model.addAttribute("user", user);
		return "Edituser";
	}

	@PostMapping("/updateuser")
	public String updateUser(UserBean user) {
		System.out.println("before updation");
		userdao.updateUser(user);
		System.out.println("after updation");
		return "redirect:/listusers";
	}

	@GetMapping("/searchuser")
	public String searchUser() {
		return "SearchUser";
	}

	@GetMapping("/searchuserbyname")
	public String searchUserByName(@RequestParam("search") String search, Model model) {

		List<UserBean> users = userdao.getUserByName(search);
		model.addAttribute("users", users);
		return "ListUsers";
	}

	// login
	// email password
	// validate -> correct --> authentication ->
	// token generate -> db store -> response
	@PostMapping("/login")
	public UserBean login(LoginDto loginDto) {
		// email password ->db -> true
		// tokenGenerate -> db save user
		//String token
		// dao.updateToken(token,userId);
		
		String token=tokenGenerator.generateToken();
		
		
		
		return null;
	}

}
