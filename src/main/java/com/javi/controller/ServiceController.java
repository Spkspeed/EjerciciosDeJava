package com.javi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @RequestMapping(value = "/loans", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getAllLoans() {
        String result = "Hola mundo";
        return result ;
    }
}