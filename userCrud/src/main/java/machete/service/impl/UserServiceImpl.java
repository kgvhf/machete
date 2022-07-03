package machete.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import machete.dto.Gender;
import machete.dto.UserDto;
import machete.dto.UserFormDto;
import machete.entity.UserEntity;
import machete.exception.UserNotFoundException;
import machete.exception.UserValidationException;
import machete.repository.UserRepository;
import machete.service.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConversionService conversionService;

    private final Validator validator;

    @Override
    public UserDto get(Long id) {
        var userOptional = userRepository.findById(id);
        var user = userOptional.orElseThrow(() -> new UserNotFoundException(id));
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public List<UserDto> getList() {
        return userRepository.findAll().stream().map(userEntity -> conversionService.convert(userEntity, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserFormDto userFormDto) {
        validateUserForm(userFormDto);
        var user = conversionService.convert(userFormDto, UserEntity.class);
        var savedUser = userRepository.save(user);
        return conversionService.convert(savedUser, UserDto.class);
    }

    @Override
    public UserDto update(Long id, UserFormDto userFormDto) {
        var userOptional = userRepository.findById(id);
        var user = userOptional.orElseThrow(() -> new UserNotFoundException(id));

        if (userFormDto.getAge() == null) {
            userFormDto.setAge(user.getAge());
        }

        if (userFormDto.getComment() == null) {
            userFormDto.setComment(user.getComment());
        }

        if (userFormDto.getName() == null) {
            userFormDto.setName(user.getName());
        }

        if (userFormDto.getGender() == null) {
            userFormDto.setGender(user.getGender().name());
        }

        if (userFormDto.getPassportNumber() == null) {
            userFormDto.setPassportNumber(user.getPassportNumber());
        }

        validateUserForm(userFormDto);
        var updatableUser = conversionService.convert(userFormDto, UserEntity.class);
        updatableUser.setId(id);
        var savedUser = userRepository.save(updatableUser);
        return conversionService.convert(savedUser, UserDto.class);
    }

    private void validateUserForm(UserFormDto userFormDto) {
        var constraints = validator.validate(userFormDto);
        if (constraints.isEmpty()) {
            return;
        }
        throw new UserValidationException(constraints.stream()
                .map(userFormDtoConstraintViolation ->
                        userFormDtoConstraintViolation.getPropertyPath() + " "
                                + userFormDtoConstraintViolation.getMessage())
                .collect(Collectors.joining(",")));
    }
}
