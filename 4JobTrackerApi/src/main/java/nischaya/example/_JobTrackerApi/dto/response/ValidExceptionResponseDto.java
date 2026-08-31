package nischaya.example._JobTrackerApi.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidExceptionResponseDto {

    private LocalDateTime timeStamp;
    private int statusCode;
    private String error;
    private String message;
    private String path;
    private Map<String,String>errors; // All other fields go inside this map
}
