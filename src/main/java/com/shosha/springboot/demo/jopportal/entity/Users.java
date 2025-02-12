package com.shosha.springboot.demo.jopportal.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "password")
    private String password;

    @Column(name = "registration_date")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date registrationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_Type_Id", referencedColumnName = "user_Type_Id")
    private UsersType userTypeId;

}
