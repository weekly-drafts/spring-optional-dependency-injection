package com.marcosbarbero.wd.controller;

import com.marcosbarbero.wd.service.HelloService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController {

    private Optional<HelloService> optionalHelloService;

    private HelloService helloService;

    /**
     * It's not necessary to use both together, it's just here to show how to use it.
     */
    public HelloController(Optional<HelloService> helloService,
                           ObjectProvider<HelloService> helloServiceProvider) {
        this.optionalHelloService = helloService;
        this.helloService = helloServiceProvider.getIfAvailable(DefaultHelloService::new);
    }

    @GetMapping("/hello")
    public String hello() {
        return optionalHelloService.orElse(this.helloService).hello();
    }

    class DefaultHelloService implements HelloService {

        @Override
        public String hello() {
            return "Hello there, fallback!";
        }
    }

}
