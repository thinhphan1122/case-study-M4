package com.winz_fast.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date_of_birth", length = 20, nullable = false)
    private String dateOfBirth;
    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;
    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;
    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;
    @Column(name = "password", length = 50, nullable = false)
    private String password;
    @Column(name = "phone_number", length = 15, nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = "avatar")
    private String avatar;
    @OneToMany(mappedBy = "userId")
    private List<Product> products;
    @OneToMany(mappedBy = "userId")
    private List<Address> addresses;
}
