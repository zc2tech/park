package com.niyaowin.park.controller.staff;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niyaowin.park.entity.Greeting;

@Controller
public class StaffController {

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "staff/register";
    }
}
