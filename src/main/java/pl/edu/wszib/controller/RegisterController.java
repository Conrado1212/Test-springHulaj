package pl.edu.wszib.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.model.RegisterUser;
import pl.edu.wszib.model.User;
import pl.edu.wszib.services.IUserService;

@Controller
public class RegisterController {
    @Autowired
    IUserService userService;

    public RegisterController() {
    }

    @RequestMapping(value = {"/registerPage"}, method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("userModel", new RegisterUser());
        model.addAttribute("incorrectRepeat", "");
        return "registerPage";
    }

    @RequestMapping(value = {"/register"}, method =RequestMethod.POST)
    public String register(@ModelAttribute RegisterUser registerUser, Model model) {
        if (registerUser.getPass().equals(registerUser.getRepeatPass())) {
            this.userService.registerUser(this.convertRegisterUserToUser(registerUser));
            return "main";
        } else {
            model.addAttribute("userModel", new RegisterUser());
            model.addAttribute("incorrectRepeat", "Złe hasło !!");
            return "registerPage";
        }
    }

    private User convertRegisterUserToUser(RegisterUser registerUser) {
        User user = new User();
        user.setLogin(registerUser.getLogin());
        user.setPass(registerUser.getPass());
        user.setName(registerUser.getName());
        user.setSurname(registerUser.getSurname());
        user.setAge(registerUser.getAge());
        return user;
    }
}
