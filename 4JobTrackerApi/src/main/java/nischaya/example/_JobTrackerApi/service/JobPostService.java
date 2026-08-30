package nischaya.example._JobTrackerApi.service;

import nischaya.example._JobTrackerApi.dto.request.JobPostRequestDto;
import nischaya.example._JobTrackerApi.dto.request.UpdateRequestDto;
import nischaya.example._JobTrackerApi.dto.response.JobPostResponseDto;
import nischaya.example._JobTrackerApi.entity.JobPost;
import nischaya.example._JobTrackerApi.repository.JobPostRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class JobPostService {

    private JobPostRepository jobPostRepository;

    public JobPostService(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    public JobPostResponseDto createJobPost(JobPostRequestDto jobPostRequestDto){

        JobPost jobPost = mapToEntity(jobPostRequestDto);
        JobPost savedPost = jobPostRepository.save(jobPost);

        JobPostResponseDto jobPostResponseDto = mapToDto(savedPost);
        return jobPostResponseDto;
    }

    public JobPostResponseDto getJobPost(Long id){
        Optional<JobPost> jobPost = jobPostRepository.findById(id);
        if (jobPost.isPresent()) return mapToDto(jobPost.get());
        return null;
    }

    public JobPostResponseDto updateJobPost(UpdateRequestDto requestDto, Long id){
        Optional<JobPost> jobPost = jobPostRepository.findById(id);
        if (jobPost.isEmpty()) return null;

        // Change to updated entity first
        JobPost existingJobPost = jobPost.get();
        existingJobPost.setDescription(requestDto.getDescription());
        existingJobPost.setMinExperience(requestDto.getMinExperience());
        existingJobPost.setSalary(requestDto.getSalary());
        existingJobPost.setTitle(requestDto.getTitle());

        // Map to response DTO
        JobPost savedJob = jobPostRepository.save(existingJobPost);
        return mapToDto(savedJob);
    }

    public void deleteJobPost(Long id){
        Optional<JobPost> jobToBeDeleted = jobPostRepository.findById(id);
        if (jobToBeDeleted.isPresent()) {
            jobPostRepository.delete(jobToBeDeleted.get());
        }
    }

    public void softDelete(Long id){
        Optional<JobPost> jobToBeDeleted = jobPostRepository.findByIdAndIsArchivedIsFalse(id);
        if (jobToBeDeleted.isPresent()) {
            JobPost jobPost = jobToBeDeleted.get();
            jobPost.setArchived(true);
            jobPostRepository.save(jobPost);
        }
    }

    private JobPost mapToEntity(JobPostRequestDto jobPostRequestDto){

        JobPost jobPost = new JobPost();
        jobPost.setDescription(jobPostRequestDto.getDescription());
        jobPost.setCompanyEmail(jobPostRequestDto.getCompanyEmail());
        jobPost.setMinExperience(jobPostRequestDto.getMinExperience());
        jobPost.setSalary(jobPostRequestDto.getSalary());
        jobPost.setTitle(jobPostRequestDto.getTitle());
        jobPost.setCreatedAt(LocalDateTime.now());
        jobPost.setUpdatedAt(LocalDateTime.now());

        return jobPost;
    }

    private JobPostResponseDto mapToDto(JobPost jobPost){

        JobPostResponseDto jobPostResponseDto = new JobPostResponseDto();
        jobPostResponseDto.setCompanyEmail(jobPost.getCompanyEmail());
        jobPostResponseDto.setCreatedAt(jobPost.getCreatedAt());
        jobPostResponseDto.setDescription(jobPost.getDescription());
        jobPostResponseDto.setMinExperience(jobPost.getMinExperience());
        jobPostResponseDto.setSalary(jobPost.getSalary());
        jobPostResponseDto.setTitle(jobPost.getTitle());
        jobPostResponseDto.setUpdatedAt(LocalDateTime.now());
        jobPostResponseDto.setId(jobPost.getId()); // Response shall also show id

        return jobPostResponseDto;
    }
}
