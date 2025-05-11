package com.wanted.preonboarding_back.domain.seller.entity;

import com.wanted.preonboarding_back.domain.product.entity.ProductEntity;
import com.wanted.preonboarding_back.global.common.entity.BaseCreatedTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sellers")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SellerEntity extends BaseCreatedTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "rating")
    private BigDecimal rating;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "contact_phone")
    private String contactPhone;

    @OneToMany(mappedBy = "sellerEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> productEntities = new ArrayList<>();
}
