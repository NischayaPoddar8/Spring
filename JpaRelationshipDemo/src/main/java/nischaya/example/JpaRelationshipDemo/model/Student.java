package nischaya.example.JpaRelationshipDemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Adds all getters
@Setter
@AllArgsConstructor // All argument constructor
@NoArgsConstructor
@Entity // Displays it in table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(optional = false) // Tells hibernate department shall exist
    @JoinColumn(name = "dept_id",nullable = false) // dept_id cant be null tells database level
    private Department department;


}
