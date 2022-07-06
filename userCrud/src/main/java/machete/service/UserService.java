package machete.service;

import java.util.List;
import machete.domain.UserRequest;
import machete.domain.UserResponse;
import machete.domain.UserUpdateRequest;


public interface UserService {
    UserResponse get(Long id);
    List<UserResponse> getList();
    UserResponse create(UserRequest userFormDto);
    UserResponse update(Long id, UserUpdateRequest userFormDto);
}
