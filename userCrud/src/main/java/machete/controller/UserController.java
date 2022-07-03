package machete.controller;

import lombok.RequiredArgsConstructor;
import machete.dto.ErrorDto;
import machete.dto.UserDto;
import machete.dto.UserFormDto;
import machete.exception.UserValidationException;
import machete.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        return userService.get(id);
    }

    @GetMapping("")
    public List<UserDto> getList() {
        return userService.getList();
    }

    @PostMapping("")
    public UserDto create(@RequestBody UserFormDto userFormDto) {
        return userService.create(userFormDto);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserFormDto userFormDto) {
        return userService.update(id, userFormDto);
    }


}
