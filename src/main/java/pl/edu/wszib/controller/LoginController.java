package pl.edu.wszib.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.model.User;

import javax.annotation.Resource;

@Controller
public class LoginController {
    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String mainSite(){
        return "redirect:loginPage";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView loginPage( ) {
        return new ModelAndView("loginPage", "loginKey", new User());
    }

    @RequestMapping(value = "/loginPage",method = RequestMethod.POST)
    public String loginForm(@ModelAttribute("loginKey") User user){
        if(user.getLogin().equals("admin") && user.getPass().equals("admin") || user.getLogin().equals("admin1") && user.getPass().equals("admin1")
                || user.getLogin().equals("admin2") && user.getPass().equals("admin2") || user.getLogin().equals("admin3") && user.getPass().equals("admin3")){
            this.sessionObject.setUser(user);
            return "redirect:scooter_page";
        }
        System.out.println(user);
        return "loginPage";
    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        this.sessionObject.setUser(null);
        return "redirect:loginPage";
    }

}
