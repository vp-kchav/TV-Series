/*
 * Created on Dec 10, 2017
 */
package mum.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class LoginController {

    public LoginController() {
        // TODO Auto-generated constructor stub
    }

    @GetMapping(value ="/loginError")
    public String loginFail(Model model) {
        //request.setAttribute("msg", null);
        model.addAttribute("msg","email or password is incorrect!!!");
        return "login";
    }
    
    @GetMapping(value ="/login")
    public String getLogin(Model model) {
        return "login";
    }
    
    @GetMapping(value="/logout")
    public String logoutPage (SessionStatus status ,HttpServletRequest request, HttpServletResponse response,Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        status.setComplete();
        return "redirect:/login";
    }
}
