package lhng.learning.microservice.photoapp.users.service.impl;

import lhng.learning.microservice.photoapp.users.dto.CreateUserDTO;
import lhng.learning.microservice.photoapp.users.dto.request.CreateUserRequest;
import lhng.learning.microservice.photoapp.users.dto.response.CreateUserResponse;
import lhng.learning.microservice.photoapp.users.entity.User;
import lhng.learning.microservice.photoapp.users.mapper.UserMapper;
import lhng.learning.microservice.photoapp.users.repository.UserRepository;
import lhng.learning.microservice.photoapp.users.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserServiceImpl implements CreateUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {

        CreateUserDTO createUserDTO = userMapper.mapToUserCreateDTO(createUserRequest);
        User user = userMapper.mapDtoToUserEntity(createUserDTO);

        userRepository.save(user);
        CreateUserResponse userResponse =  userMapper.mapToUserCreateResponse(user);

        return userResponse;
    }


}
