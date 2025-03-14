package lhng.learning.microservice.photoapp.users.controller;

import lhng.learning.microservice.photoapp.users.dto.request.CreateUserRequest;
import lhng.learning.microservice.photoapp.users.dto.response.CreateUserResponse;
import lhng.learning.microservice.photoapp.users.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
@RestController
public class UsersController {
    @Autowired
    private Environment environment;
    @Autowired
    private CreateUserService createUserService;

    @GetMapping("/status/check")
    public String status(){
        return "Working on port: "+ environment.getProperty("local.server.port");
    }

    @PostMapping()
    public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest)
    {
       return createUserService.createUser(createUserRequest);
    }
}
