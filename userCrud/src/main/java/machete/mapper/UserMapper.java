package machete.mapper;

import java.util.List;
import machete.domain.UserRequest;
import machete.domain.UserResponse;
import machete.domain.UserUpdateRequest;
import machete.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

  UserResponse toUserResponse(UserEntity userEntity);

  UserRequest toUserRequest(UserEntity request);

  List<UserResponse> toUserResponses(List<UserEntity> userEntityList);

  UserEntity toUserEntity(UserRequest userCreateRequest);

  void updateUserEntity(@MappingTarget UserEntity userEntity, UserUpdateRequest updateRequest);
}
