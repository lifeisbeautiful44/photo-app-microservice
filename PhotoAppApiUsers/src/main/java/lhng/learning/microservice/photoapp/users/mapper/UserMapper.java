package lhng.learning.microservice.photoapp.users.mapper;

import lhng.learning.microservice.photoapp.users.dto.CreateUserDTO;
import lhng.learning.microservice.photoapp.users.dto.request.CreateUserRequest;
import lhng.learning.microservice.photoapp.users.dto.response.CreateUserResponse;
import lhng.learning.microservice.photoapp.users.entity.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {
    public CreateUserDTO mapToUserCreateDTO(CreateUserRequest createUserRequest) {

        CreateUserDTO createUserDTO =  new CreateUserDTO();

        createUserDTO.setUserUid(UUID.randomUUID().toString());
        createUserDTO.setFirstName(createUserRequest.getFirstName());
        createUserDTO.setLastName(createUserRequest.getLastName());
        createUserDTO.setEmail(createUserRequest.getEmail());
        createUserDTO.setEncryptedPassword(createUserRequest.getPassword());

        return createUserDTO;

    }

    public User mapDtoToUserEntity(CreateUserDTO createUserDTO) {
        User user = new User();

        user.setUserUid(createUserDTO.getUserUid());
        user.setFirstName(createUserDTO.getFirstName());
        user.setLastName(createUserDTO.getLastName());
        user.setEmail(createUserDTO.getEmail());
        user.setEncryptedPassword(createUserDTO.getEncryptedPassword());

        return user;
    }

    public CreateUserResponse mapToUserCreateResponse(User user) {

        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setUserUid(user.getUserUid());
        createUserResponse.setFirstName(user.getFirstName());
        createUserResponse.setLastName(user.getLastName());
        createUserResponse.setEmail(user.getEmail());
        return createUserResponse;

    }
}
