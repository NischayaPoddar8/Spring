package nischaya.example._JobTrackerApi.controller;

import nischaya.example._JobTrackerApi.dto.request.JobPostRequestDto;
import nischaya.example._JobTrackerApi.service.JobPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobPost")
public class JobPostController {

    private JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @PostMapping
    public ResponseEntity<String>createJobPost(@RequestBody JobPostRequestDto jobPostRequestDto){
        jobPostService.createJobPost(jobPostRequestDto);
        return ResponseEntity.ok("Job Post created");
    }
}
