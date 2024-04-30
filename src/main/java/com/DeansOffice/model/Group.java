package com.DeansOffice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_group")
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupId")
    private Long groupId;

    @Column(name = "groupName", length = 100)
    private String groupName;

    @Column(name = "enrollment")
    private String enrollment;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "facultyId")
    private Faculty faculty;
}
