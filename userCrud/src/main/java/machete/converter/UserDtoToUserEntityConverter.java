package machete.converter;

import machete.dto.Gender;
import machete.dto.UserDto;
import machete.dto.UserFormDto;
import machete.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserEntityConverter implements Converter<UserFormDto, UserEntity> {

    @Override
    public UserEntity convert(UserFormDto source) {
        return new UserEntity()
                .setAge(source.getAge())
                .setComment(source.getComment())
                .setGender(Gender.valueOf(source.getGender()))
                .setName(source.getName())
                .setPassportNumber(source.getPassportNumber());
    }
}
