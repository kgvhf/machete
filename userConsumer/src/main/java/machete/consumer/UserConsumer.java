package machete.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import machete.binder.ConsumerBinding;
import machete.dto.UserDto;
import machete.service.UserService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableBinding(ConsumerBinding.class)
@RequiredArgsConstructor
public class UserConsumer {

  private final UserService userService;

  @StreamListener(ConsumerBinding.BINDING_TARGET_NAME)
  public void consumeUsers(UserDto userDto) {
    log.info("Событие из очереди " + userDto.toString());
    userService.saveUser(userDto);
  }

}
