package com.wanted.preonboarding_back.domain.brand.entity;

import com.wanted.preonboarding_back.domain.product.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String slug;

    @Column(name = "description")
    private String description;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "website")
    private String website;

    @OneToMany(mappedBy = "brandEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> productEntities = new ArrayList<>();
}
