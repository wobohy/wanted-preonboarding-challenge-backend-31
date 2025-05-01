package com.wanted.preonboarding_back.domain.product.entity;

import com.wanted.preonboarding_back.domain.categories.entity.Categories;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "product_categories")
@Getter
public class ProductCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Categories categories;

    @Column(name = "is_primary")
    private boolean isPrimary;

}
