package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.IScooterDAO;

import javax.annotation.Resource;

@Controller
public class ScootersController {


    @Resource(name = "sessionObject")
    SessionObject sessionObject;


    @Autowired
    IScooterDAO scooterDAO;

    @RequestMapping(value ="/allScooter",method = RequestMethod.GET)
    public String allScooter(Model model){
        model.addAttribute("allScooter",this.scooterDAO.getAllScooters());
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        return "allScooter";
    }

    @RequestMapping(value = "/allScooterXiomi",method = RequestMethod.GET)
    public String scooterXiaomiPage(Model model){

        model.addAttribute("allScooterXiomi",this.scooterDAO.getAllScooterXiaomi());
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        return"allScooterXiomi";
    }

    @RequestMapping(value = "/allScooterFiat",method = RequestMethod.GET)
    public String scooterFiatPage(Model model){

        model.addAttribute("allScooterFiat",this.scooterDAO.getAllScooterFiat());
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        return "allScooterFiat";
}
    }
