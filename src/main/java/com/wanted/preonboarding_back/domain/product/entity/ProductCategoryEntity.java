package com.wanted.preonboarding_back.domain.product.entity;

import com.wanted.preonboarding_back.domain.categories.entity.CategoryEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "product_categories")
@Getter
public class ProductCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @Column(name = "is_primary")
    private boolean isPrimary;

}
