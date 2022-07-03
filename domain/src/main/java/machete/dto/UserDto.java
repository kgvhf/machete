package machete.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto {
    private Long id;
    private String passportNumber;
    private String name;
    private Integer age;
    private Gender gender;
    private String comment;
}
