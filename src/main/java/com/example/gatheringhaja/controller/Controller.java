package com.example.gatheringhaja.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/meeting")
public class Controller {

    @GetMapping("/registered")
    public String hello() {
        return "hello";
    }

}
