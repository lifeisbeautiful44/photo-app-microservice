package lhng.learning.microservice.photoapp.users.service;

import lhng.learning.microservice.photoapp.users.dto.request.CreateUserRequest;
import lhng.learning.microservice.photoapp.users.dto.response.CreateUserResponse;

public interface CreateUserService {
    CreateUserResponse createUser(CreateUserRequest createUserRequest);
}
