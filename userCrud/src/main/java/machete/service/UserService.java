package machete.service;

import machete.dto.UserDto;
import machete.dto.UserFormDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    UserDto get(Long id);
    List<UserDto> getList();
    UserDto create(UserFormDto userFormDto);
    UserDto update(Long id, UserFormDto userFormDto);
}
