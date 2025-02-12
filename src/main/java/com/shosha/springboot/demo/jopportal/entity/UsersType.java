package com.shosha.springboot.demo.jopportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_type")
public class UsersType {
    @Id
    @Column(name = "user_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userTypeId;

    @Column(name = "user_type_name")
    private String userTypeName;

    @OneToMany(mappedBy = "userTypeId", targetEntity = Users.class, cascade = CascadeType.ALL)
    private List<Users> users;

    @Override
    public String toString() {
        return "UsersType{" +
                "userTypeId=" + userTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
