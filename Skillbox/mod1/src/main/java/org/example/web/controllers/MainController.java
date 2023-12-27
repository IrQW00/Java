package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private Logger logger = Logger.getLogger(MainController.class);

    @GetMapping
    public String hello(){
        logger.info("Hi");
        return "login_page";
    }
}
