package com.winz_fast.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "street",length = 50)
    private String street;
    @Column(name = "district", length = 50)
    private String district;
    @Column(name = "city",length = 50)
    private String city;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;
}
