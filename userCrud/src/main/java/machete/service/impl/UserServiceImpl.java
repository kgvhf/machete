package machete.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import machete.domain.UserRequest;
import machete.domain.UserResponse;
import machete.domain.UserUpdateRequest;
import machete.exception.UserNotFoundException;
import machete.mapper.UserMapper;
import machete.repository.UserRepository;
import machete.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public UserResponse get(Long id) {
    var userOptional = userRepository.findById(id);
    var user = userOptional.orElseThrow(() -> new UserNotFoundException(id));
    return userMapper.toUserResponse(user);
  }

  @Override
  public List<UserResponse> getList() {
    return userMapper.toUserResponses(userRepository.findAll());
  }

  @Override
  public UserResponse create(UserRequest userFormDto) {
    var user = userMapper.toUserEntity(userFormDto);
    var savedUser = userRepository.save(user);
    return userMapper.toUserResponse(savedUser);
  }

  @Override
  public UserResponse update(Long id, UserUpdateRequest userFormDto) {
    var userOptional = userRepository.findById(id);
    var user = userOptional.orElseThrow(() -> new UserNotFoundException(id));

    userMapper.updateUserEntity(user, userFormDto);

    var savedUser = userRepository.save(user);
    return userMapper.toUserResponse(savedUser);
  }
}
