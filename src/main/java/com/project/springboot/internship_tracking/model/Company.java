package com.project.springboot.internship_tracking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name="company_email")
    private String companyEmail;

    @JsonIgnore //json ignore olmayinca iteratif olarak sürekli aynı kayıtlar geliyor.
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "student_company_list",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Student> studentList=new ArrayList<>();
}
