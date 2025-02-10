package com.shosha.springboot.demo.jopportal.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "is_active")
    private Boolean active;

    @Column(name = "password")
    private String password;

    @Column(name = "registration_date")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date registrationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_Type_Id", referencedColumnName = "user_Type_Id")
    private UsersType usersTypeId;

    public Users() {
    }

    public Users(int id, String email, Boolean active, String password, Date registrationDate, UsersType usersTypeId) {
        this.id = id;
        this.email = email;
        this.active = active;
        this.password = password;
        this.registrationDate = registrationDate;
        this.usersTypeId = usersTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UsersType getUsersTypeId() {
        return usersTypeId;
    }

    public void setUsersTypeId(UsersType usersTypeId) {
        this.usersTypeId = usersTypeId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                ", usersTypeId=" + usersTypeId +
                '}';
    }
}
