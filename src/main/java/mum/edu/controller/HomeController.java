/*
 * Created on Nov 15, 2017
 */
package mum.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
//@SessionAttributes("currentUser")
public class HomeController {

    @RequestMapping(value = {"/","/index","/home"} , method = RequestMethod.GET)
    public String index(Model model) {
        System.out.println("login do"); 
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            String email = ((UserDetails)principal).getUsername();
//            String pass = ((UserDetails)principal).getPassword();
//            user.setEmail(((UserDetails)principal).getUsername());
//            User user = userService.getByEmail(email);
//            List<Property> properties = propertyService.getPropertiesByStatus(PropertyStatus.APPROVED);
//            model.addAttribute("hotProperties",properties);
//            model.addAttribute("currentUser", user);
//        }
        return "home";
    }
//    
//    @RequestMapping(value="/logout", method = RequestMethod.GET)
//    public String logoutPage (SessionStatus status ,HttpServletRequest request, HttpServletResponse response,Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){    
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        status.setComplete();
//        return "redirect:/login";
//    }
//    
//    @RequestMapping(value = {"/agents"} , method = RequestMethod.GET)
//    public String getAgents(Model model) {
//        List<User> agents = userService.getAgents();
//        model.addAttribute("agents", agents);
//        return "agent";
//    }
//    
//    @RequestMapping(value = {"/agents"} , method = RequestMethod.GET)
//    public String getSale(Model model) {
//        return "Sale";
//    }
//    
//    @RequestMapping(value = {"/agents"} , method = RequestMethod.GET)
//    public String getRent(Model model) {
//        return "agent";
//    }

}
