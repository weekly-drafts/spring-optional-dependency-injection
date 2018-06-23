package com.marcosbarbero.wd.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProductionHelloService implements HelloService {

    @Override
    public String hello() {
        return "Hello there general Kenobi!";
    }

}
