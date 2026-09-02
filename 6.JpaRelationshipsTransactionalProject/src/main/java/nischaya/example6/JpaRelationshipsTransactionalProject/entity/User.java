package nischaya.example6.JpaRelationshipsTransactionalProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Long id;

    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_profile") // User is owning side has fk of userProfile inside it
    // Join column is exclusive to owning side
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL) // User is inverse side and used as fk
    private List<Order>orderList;
}
