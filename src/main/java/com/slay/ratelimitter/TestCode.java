package com.slay.ratelimitter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestCode {

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
}
