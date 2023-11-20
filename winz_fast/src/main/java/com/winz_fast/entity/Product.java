package com.winz_fast.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "product_date", length = 50)
    private String productDate;
    @Column(name = "price")
    private String price;
    @Column(name = "view")
    private Integer view;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;
    @OneToMany(mappedBy = "productId")
    private List<Specification> specifications;

}
