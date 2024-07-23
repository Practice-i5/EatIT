package com.i7.eatit.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/*")
public class HomeController {

    @GetMapping("home")
    public void home() {}

}
