package com.kodnest.TuneHub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.TuneHub.Entities.Song;
import com.kodnest.TuneHub.Entities.Users;
import com.kodnest.TuneHub.Services.SongService;
import com.kodnest.TuneHub.Services.UsersServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	UsersServices userss;
	@Autowired
	SongService sserv;

	@PostMapping("register")
	public String addUser(@ModelAttribute Users user) {
		boolean userStatus = userss.emailExists(user.getEmail());
		if (userStatus == false) {
			userss.addUser(user);
			return "registersuccess";
		} 
		else 
		{
			return "registerfail";
		}
	}

	@PostMapping("login")
	public String validateUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
		boolean emailExists = userss.emailExists(email);
        if (!emailExists) {
             // Email does not exist in the database, show registration fail message
             return "loginfail";
        }
		boolean loginstatus = userss.validateUser(email, password);
		if (loginstatus == true) {
			session.setAttribute("email", email);
			if(userss.getRole(email).equals("Admin")) {
				return "adminhome";
			}
			else 
			{
				return "customerhome";
			}
		} 
		else 
		{
			return "loginfail";
		}
	}
	
	@GetMapping("/exploresongs")
	public String exploreSongs(HttpSession session,Model model) {
		String email = (String) session.getAttribute("email");
		Users user= userss.getUser(email);
		boolean userStatus = user.isPremium();
		if(userStatus == true) {
			List<Song> lis = sserv.viewSongs();
			model.addAttribute("songs",lis);
			return "viewcustomersongs";
		}
		else {
			return "payment";
		}
	}

}
