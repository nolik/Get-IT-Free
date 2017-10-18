package com.getItFree.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nolik on 02.07.17.
 */
@Controller
public class RootController {

    @RequestMapping("/")
    public String showIndexPage(){
        return "index";
    }
}
