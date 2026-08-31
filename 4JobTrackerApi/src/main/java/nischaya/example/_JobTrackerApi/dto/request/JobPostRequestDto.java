package nischaya.example._JobTrackerApi.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobPostRequestDto {

    @NotBlank
    @Size(min = 3,max = 30)
    private String title;

    @NotBlank
    private String description;

    @Email
    @NotBlank
    private String companyEmail;

    @NotNull
    @Min(3)
    @Max(20)
    private Integer minExperience;

    @NotNull
    @Positive
    private Double salary;

}
