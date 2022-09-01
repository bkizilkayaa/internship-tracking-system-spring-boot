package com.project.springboot.internship_tracking.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter

@RequiredArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Integer companyId;

    @Column
    private String email;

    @ManyToOne
    @JoinTable(
            name = "enrolled_students",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lecturer_id")
    )
    private Lecturer _lecturer=new Lecturer();


}
