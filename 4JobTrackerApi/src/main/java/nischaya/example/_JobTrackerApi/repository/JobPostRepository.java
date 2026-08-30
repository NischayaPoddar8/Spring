package nischaya.example._JobTrackerApi.repository;

import nischaya.example._JobTrackerApi.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost,Long> {

    public Optional<JobPost> findByIdAndIsArchivedIsFalse(Long id);
}
