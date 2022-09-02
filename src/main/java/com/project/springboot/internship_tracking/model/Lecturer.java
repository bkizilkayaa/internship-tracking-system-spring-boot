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
@Table(name = "lecturer")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "_lecturer")
    private List<Student> studentList= new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "lecturerMessage")
    public List<Message> messageList= new ArrayList<>();



}
