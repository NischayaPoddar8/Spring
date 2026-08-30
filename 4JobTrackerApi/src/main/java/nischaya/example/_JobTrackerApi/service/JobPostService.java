package nischaya.example._JobTrackerApi.service;

import nischaya.example._JobTrackerApi.dto.request.JobPostRequestDto;
import nischaya.example._JobTrackerApi.repository.JobPostRepository;
import org.springframework.stereotype.Service;

@Service
public class JobPostService {

    private JobPostRepository jobPostRepository;

    public JobPostService(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    public void createJobPost(JobPostRequestDto jobPostRequestDto){
        
        jobPostRepository.save(jobPostResponseDto);
    }
}
