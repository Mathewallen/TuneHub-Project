package com.kodnest.TuneHub.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	@GetMapping("register")
	public String mapRegister() {
		return "register";
	}
	
	@GetMapping("login")
	public String mapLogin() {
		return "login";
	}
	
	@GetMapping("logOut")
	public String LogOut() {
		return "login";
	}
	
	@GetMapping("mapSong")
	public String mapSongs() {
		return "addsongs";
	}
	
	@GetMapping("samplepayment")
	public String samplepayment() {
		return "samplepayment";
	}
	
	@GetMapping("home")
	public String home() {
		return "adminhome";
	}
	
	@GetMapping("customerhome")
	public String customerhome() {
		return "customerhome";
	}
}
