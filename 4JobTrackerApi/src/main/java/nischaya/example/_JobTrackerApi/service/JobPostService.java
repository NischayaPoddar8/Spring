package nischaya.example._JobTrackerApi.service;

import nischaya.example._JobTrackerApi.dto.request.JobPostRequestDto;
import nischaya.example._JobTrackerApi.dto.request.UpdateRequestDto;
import nischaya.example._JobTrackerApi.dto.response.JobPostResponseDto;
import nischaya.example._JobTrackerApi.entity.JobPost;
import nischaya.example._JobTrackerApi.exception.ResourceNotFoundException;
import nischaya.example._JobTrackerApi.repository.JobPostRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

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
        JobPost jobPost = jobPostRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("No job with id = " + id + "found")
        );
        return mapToDto(jobPost);
    }

    public JobPostResponseDto updateJobPost(UpdateRequestDto requestDto, Long id){

        JobPost jobPost = jobPostRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("No job with id = " + id + "found")
        );

        // Change to updated entity first
        jobPost.setDescription(requestDto.getDescription());
        jobPost.setMinExperience(requestDto.getMinExperience());
        jobPost.setSalary(requestDto.getSalary());
        jobPost.setTitle(requestDto.getTitle());

        // Map to response DTO
        JobPost savedJob = jobPostRepository.save(jobPost);
        return mapToDto(savedJob);
    }

    public void deleteJobPost(Long id){

        JobPost jobToBeDeleted = jobPostRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("No job with id = " + id + "found")
        );

        jobPostRepository.delete(jobToBeDeleted);
    }

    public void softDelete(Long id){

        JobPost jobToBeDeleted = jobPostRepository.findByIdAndIsArchivedIsFalse(id)
                .orElseThrow( ()->new ResourceNotFoundException("No job with id = " + id + "found")
        );

        jobToBeDeleted.setArchived(true);
        jobToBeDeleted.setUpdatedAt(LocalDateTime.now());
        jobPostRepository.save(jobToBeDeleted);

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
