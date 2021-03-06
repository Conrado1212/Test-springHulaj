package pl.edu.wszib.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.impl.ScooterDAOImpl;
import pl.edu.wszib.model.Scooter;

import javax.annotation.Resource;

@Controller
public class ScooterController {

    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @Autowired
    ScooterDAOImpl scooterDAO;

    @RequestMapping(value = "/scooter_page",method = RequestMethod.GET)
    public ModelAndView scooterPage(){
        return new ModelAndView("scooterPage","scooterKey",new Scooter());
   }


    @RequestMapping(value = "/scooter_page",method = RequestMethod.POST)
    public String scooterForm(@ModelAttribute("scooterKey")Scooter scooter){
        System.out.println(scooter);
        return "scooterPage";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }


    @RequestMapping(value = "/addScooter",method = RequestMethod.GET)
    public ModelAndView addScooter(){

        return new ModelAndView("addScooter","addScooterKey",new Scooter());

    }

    @RequestMapping(value = "/addScooter",method = RequestMethod.POST)
    public String addScooterForm(@ModelAttribute("addScooterKey")Scooter scooter){

        Scooter scooter1 = new Scooter();
        scooter1 = scooter;
        this.scooterDAO.addScooter(scooter);

        return  "redirect:indexAddScooter";
    }

    @RequestMapping(value = "/indexAddScooter",method = RequestMethod.GET)
    public String indexAddScooter(){
        return"indexAddScooter";
    }

    @RequestMapping(value = "/removeScooterId",method = RequestMethod.GET)
    public ModelAndView removeScooterId(){
        return new ModelAndView("removeScooterId","removeScooterIdKey",new Scooter());
    }

    @RequestMapping(value = "/removeScooterId",method = RequestMethod.POST)
    public String removeScooterIdForm(@ModelAttribute("removeScooterIdKey")Scooter scooter){
        this.scooterDAO.removeScooterId(scooter.getId());
        return "redirect:indexRemoveScooterId";
    }

    @RequestMapping(value = "/indexRemoveScooterId",method = RequestMethod.GET)
    public String indexRemoveScooterId(){
        return"indexRemoveScooterId";
    }

    @RequestMapping(value = "/getScooter",method = RequestMethod.GET)
    public ModelAndView getScooter(){
        return new ModelAndView("getScooter","getScooterKey",new Scooter());
    }

    @RequestMapping(value = "/getScooter",method = RequestMethod.POST)
    public String getScooterForm(@ModelAttribute("getScooterKey")Scooter scooter){
        this.scooterDAO.getScooter(scooter.getId());
        return "redirect:indexGetScooter";
    }

    @RequestMapping(value = "/indexGetScooter",method = RequestMethod.GET)
    public String indexGetScooter(){

        return"indexGetScooter";
    }

    @RequestMapping(value = "/updateScooter",method = RequestMethod.GET)
    public ModelAndView updateScooter(){
        return new ModelAndView("updateScooter","updateScooterKey",new Scooter());
    }

    @RequestMapping(value = "/updateScooter",method = RequestMethod.POST)
    public String updateScooterForm(@ModelAttribute("updateScooterKey")Scooter scooter){
        this.scooterDAO.getUpdate(scooter.getId(),scooter);
        return "redirect:indexUpdateScooter";
    }

    @RequestMapping(value = "/indexUpdateScooter",method = RequestMethod.GET)
    public ModelAndView indexUpdateScooter(){
        return new ModelAndView("indexUpdateScooter","indexUpdateScooterKey",new Scooter());
    }
    @RequestMapping(value = "/indexUpdateScooter",method = RequestMethod.POST)
    public String indexUpdateScooterForm(@ModelAttribute("indexUpdateScooterKey")Scooter scooter){
       this.scooterDAO.getUpdateScooter(scooter.getId(),scooter);
        return "redirect:indexGetUpdateScooter";
    }
    @RequestMapping(value = "/indexGetUpdateScooter",method = RequestMethod.GET)
    public String indexGetUpdateScooter(){
        return"indexGetUpdateScooter";
    }
}
