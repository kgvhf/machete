package machete.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Accessors(chain = true)
public class UserFormDto {

    @NotNull
    @Pattern(regexp = "^\\d{10}$")
    private String passportNumber;

    @NotNull
    private String name;

    @Min(0)
    @Max(200)
    @NotNull
    private Integer age;

    @NotNull
    @Pattern(regexp = "^[F|M]$")
    private String gender;

    private String comment;
}
