package net.yaco.app.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LoginController {
	

	@GetMapping(value = "/index")
	public String showIndex(Authentication authentication) {
		System.out.println("Login - Username: " + authentication.getName() + " - Time: " + new Date());
		
		for (GrantedAuthority rol : authentication.getAuthorities()) {
			System.out.println("Rol: " + rol.getAuthority());
		}
		
		return "admin";
	}

	@GetMapping(value = "/logout")
	public String logout(Authentication authentication, HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		System.out.println("Logout - Username: " + authentication.getName() + " - Time: " + new Date());
		return "redirect:/formLogin";
	}	

}
