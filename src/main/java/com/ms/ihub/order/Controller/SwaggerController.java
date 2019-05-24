package com.ms.ihub.order.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SwaggerController {

    @RequestMapping(method = RequestMethod.GET, value = "/javainuse")
    public String sayHello() {
        return "Swagger Successfully Started";
    }
}
