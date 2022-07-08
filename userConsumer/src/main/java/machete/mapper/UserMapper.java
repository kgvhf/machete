
package machete.mapper;

import machete.domain.UserRequest;
import machete.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserRequest toUserRequest(UserDto userDto);
}
