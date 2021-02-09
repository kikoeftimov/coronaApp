package com.example.knio.web;

import com.example.knio.model.Info;
import com.example.knio.service.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final InfoService infoService;

    public HomeController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping
    public String homePage(HttpServletResponse res, HttpServletRequest req){
        return "home";
    }

    @GetMapping("/add-new")
    public String createNewInfo(Model model){
        model.addAttribute("info", new Info());
        return "add-info";
    }

    @PostMapping
    public String saveInfo(@Valid Info info,
                           BindingResult bindingResult,
                           Model model) throws IOException
    {
        if(bindingResult.hasErrors()){
            return "redirect:/home/add-new?message=Please enter a valid temperature.";
        }
        try {
            this.infoService.save(info);
            if((info.isDifficultBreathing())
                    || (info.getTemperature() > 37.2 && info.isTired() && info.isCough())
                    || (info.getTemperature() > 37.2 && info.isLostOfTaste() && info.isCough())
                    || (info.getTemperature() > 37.2 && info.isLostOfTaste() && info.isTired())
                    || (info.isChestPain())
                    || (info.isCough() && info.isHeadache() && info.isLostOfTaste() && info.isSoreThroat())
            ){
                return "redirect:/home?me=Please call or visit a doctor!!!";
            }
            else if(info.isHaveBeenAbroad() && info.getTemperature() > 37.5){
                return "redirect:/home?me=Inform the doctor that you have been abroad!";
            }
            else{
                return "redirect:/home?message=You are doing fine! Take care of yourself, wash your hands, wear a mask and stay in good health!!";
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return "redirect:/home";
    }
}
