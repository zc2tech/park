package com.niyaowin.park.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niyaowin.park.entity.Greeting;

@Controller
public class HomeController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        return "home";
    }
}
