package net.javaguides.apispringboot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_Name")
    private String lastName;
    @Column(name="email_id")
    private String emailId;

}
