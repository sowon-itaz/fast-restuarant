package com.example.restuarant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class PageController {
	
	// http://localhost:8080/pages/main
	@GetMapping("/main")
    public ModelAndView main(){
        return new ModelAndView("main");
    }
}
