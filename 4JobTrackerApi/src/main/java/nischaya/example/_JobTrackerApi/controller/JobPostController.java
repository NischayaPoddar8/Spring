package nischaya.example._JobTrackerApi.controller;

import nischaya.example._JobTrackerApi.dto.request.JobPostRequestDto;
import nischaya.example._JobTrackerApi.dto.request.UpdateRequestDto;
import nischaya.example._JobTrackerApi.dto.response.JobPostResponseDto;
import nischaya.example._JobTrackerApi.service.JobPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobPost")
public class JobPostController {

    private JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @PostMapping
    public ResponseEntity<JobPostResponseDto> createJobPost(@RequestBody JobPostRequestDto jobPostRequestDto){
        JobPostResponseDto jobPostResponseDto = jobPostService.createJobPost(jobPostRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(jobPostResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPostResponseDto>getJobPost(@PathVariable Long id){
        JobPostResponseDto dto = jobPostService.getJobPost(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPostResponseDto>updateJobPost(@RequestBody UpdateRequestDto requestDto,
                                                           @PathVariable Long id){

        JobPostResponseDto updatedJobPost = jobPostService.updateJobPost(requestDto,id);
        return ResponseEntity.ok(updatedJobPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteJobPost(@PathVariable Long id){
        jobPostService.deleteJobPost(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // No JSON body to be sent
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String>softDelete(@PathVariable Long id){
        jobPostService.softDelete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
