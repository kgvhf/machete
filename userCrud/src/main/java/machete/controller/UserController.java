package machete.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import machete.UsersApi;
import machete.domain.UserRequest;
import machete.domain.UserResponse;
import machete.domain.UserUpdateRequest;
import machete.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController implements UsersApi {

  private final UserService userService;

  @Override
  public ResponseEntity<UserResponse> get(Long id) {
    return ResponseEntity.ok(userService.get(id));
  }

  @Override
  public ResponseEntity<List<UserResponse>> getList() {
    return ResponseEntity.ok(userService.getList());
  }

  @Override
  public ResponseEntity<UserResponse> create(UserRequest userCreateRequest) {
    return ResponseEntity.ok(userService.create(userCreateRequest));
  }

  @Override
  public ResponseEntity<UserResponse> update(Long id, UserUpdateRequest userUpdateRequest) {
    return ResponseEntity.ok(userService.update(id, userUpdateRequest));
  }
}
