package nischaya.example6.JpaRelationshipsTransactionalProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String phoneNo;

    @OneToOne(mappedBy = "userProfile") // User is owning side and user profile is fk
    private User user; // this name and mappedBy name shall be same
}
