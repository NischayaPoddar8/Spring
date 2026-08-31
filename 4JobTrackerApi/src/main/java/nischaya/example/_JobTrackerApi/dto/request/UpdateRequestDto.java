package nischaya.example._JobTrackerApi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequestDto {

    private String title;
    private String description;
    private int minExperience;
    private double salary;

}
