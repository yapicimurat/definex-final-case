package finalcase.service.impl;

import finalcase.api.request.user.UserPostRequest;
import finalcase.api.request.user.UserPutRequest;
import finalcase.api.response.BaseResponse;
import finalcase.api.response.DataResponse;
import finalcase.api.response.SuccessDataResponse;
import finalcase.api.response.SuccessResponse;
import finalcase.constant.UserResultMessages;
import finalcase.dto.UserDto;
import finalcase.exception.NotFoundException;
import finalcase.model.User;
import finalcase.repository.UserRepository;
import finalcase.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResponse<UserDto> create(UserPostRequest request) {
         final User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roleType(request.getRoleType())
                .build();

         final UserDto userDto = modelMapper.map(user, UserDto.class);

         return new SuccessDataResponse<>(userDto, UserResultMessages.USER_CREATE_SUCCESSFULLY);
    }

    @Override
    public DataResponse<UserDto> update(UserPutRequest request) {
        final User user = findById(UUID.fromString(request.getId()));

        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRoleType(request.getRoleType());

        final UserDto userDto = modelMapper.map(userRepository.save(user), UserDto.class);

        return new SuccessDataResponse<>(userDto, UserResultMessages.USER_UPDATE_SUCCESSFULLY);
    }

    @Override
    public BaseResponse delete(String id) {
        final User user = findById(UUID.fromString(id));

        user.setDeleted(true);
        userRepository.save(user);

        return new SuccessResponse(UserResultMessages.USER_DELETED_SUCCESSFULLY);
    }

    private User findById(UUID id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(UserResultMessages.USER_NOT_FOUND));
    }


}
