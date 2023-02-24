package com.bitacademy.cocktail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitacademy.cocktail.domain.User;
import com.bitacademy.cocktail.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
//	@Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @GetMapping("/login")
    public String login(){
        return "user/login";
    }
    
 // 회원가입
    @PostMapping("/user/join")
    public void join(@RequestBody User user){
    	
    	String rawPassword = user.getPassword();
        //String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        //user.setPassword(encPassword);
    	user.setRole("enuser");

    	userService.join(user);
    }
    
    //유저리스트
    @GetMapping("/user/list")
    public List<User> userList(Model model) {
    	List<User> userList = userService.userList();
    	model.addAttribute("userList", userList);
    	
    	return userList;
    }
}
