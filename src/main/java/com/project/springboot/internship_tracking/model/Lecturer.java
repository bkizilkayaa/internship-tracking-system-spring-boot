package com.project.springboot.internship_tracking.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "_lecturer",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Student> studentList=new ArrayList<>();


    @JsonIgnore //json ignore olmayinca iteratif olarak sürekli aynı kayıtlar geliyor.
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "lecturerMessage",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Message> messageList=new ArrayList<>();



}
