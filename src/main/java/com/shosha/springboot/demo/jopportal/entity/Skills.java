package com.shosha.springboot.demo.jopportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

}