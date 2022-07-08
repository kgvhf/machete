package machete.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto {
  private String passportNumber;
  private String name;
  private Integer age;
  private String gender;
  private String comment;
}
