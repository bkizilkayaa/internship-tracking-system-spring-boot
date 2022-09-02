package com.project.springboot.internship_tracking.model;


import lombok.*;

import javax.persistence.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;




    @ManyToOne
    @JoinTable(
            name = "lecturer_messages",
            joinColumns = @JoinColumn(name = "message_id"),
            inverseJoinColumns = @JoinColumn(name = "lecturer_id")
    )
    private Lecturer lecturerMessage=new Lecturer();


}
