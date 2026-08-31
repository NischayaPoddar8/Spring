package nischaya.example._JobTrackerApi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequestDto {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private int minExperience;
    @NotNull
    private Double salary;

}
