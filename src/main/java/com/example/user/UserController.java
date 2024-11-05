package com.example.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.user.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("")
	public String getUsers(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		// log.info("가져온 유저 정보: {}", users);
		
		return "index";
	}
	
	@PostMapping("users")
	public String createUser(@RequestParam(name = "name") String name) {
		// log.info("받은 데이터: {}", name);
		User user = new User();
		user.setName(name);
		userRepository.save(user);
		
		return "redirect:/";
	}
}
