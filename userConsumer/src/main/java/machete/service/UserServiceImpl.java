
package machete.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import machete.client.UserCrudClient;
import machete.dto.UserDto;
import machete.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;
  private final UserCrudClient userCrudClient;

  public void saveUser(final UserDto userDto) {
    var userRequest = userMapper.toUserRequest(userDto);

    try {
      var user = userCrudClient.create(userRequest);
      log.error("User успешно сохранен {}", user.getBody());
    } catch (Exception ex) {
      log.error("Ошибка сохранения user", ex);
    }
  }
}
