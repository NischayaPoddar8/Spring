package nischaya.example._JobTrackerApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String companyEmail;
    private int minExperience;
    private Double salary;
    private boolean isArchived = false; // this is for soft delete we soft-delete it instead of wiping job from database
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
