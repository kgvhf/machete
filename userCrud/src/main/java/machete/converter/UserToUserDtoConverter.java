package machete.converter;

import machete.dto.UserDto;
import machete.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<UserEntity, UserDto> {

    @Override
    public UserDto convert(UserEntity source) {
        return new UserDto()
                .setId(source.getId())
                .setAge(source.getAge())
                .setComment(source.getComment())
                .setName(source.getName())
                .setGender(source.getGender())
                .setPassportNumber(source.getPassportNumber());
    }
}
