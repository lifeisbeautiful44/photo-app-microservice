package lhng.learning.microservice.photoapp.users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("users")
@RestController
public class UsersController {
    @GetMapping("/status/check")
    public String status(){
        return "Working";
    }
}
