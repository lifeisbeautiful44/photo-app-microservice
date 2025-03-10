package lhng.learning.microservice.photoapp.account.PhotoApp_Api_Account_Management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {
    @GetMapping("/status/check")
    public String status(){
        return "Working";
    }
}
