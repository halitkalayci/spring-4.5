package com.turkcell.intro.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/test") // Tüm isteklere bir ön-ek ekler.
public class TestController {

    @GetMapping({"/hello","/merhaba"})
    public String sayHello()
    {
        return "Merhaba Dünya";
    }

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "kişi") String name,
                        @RequestParam() int age) { // Default query string
        return "Merhaba "+name + ", yaşınız: "+  age;
    }
}
