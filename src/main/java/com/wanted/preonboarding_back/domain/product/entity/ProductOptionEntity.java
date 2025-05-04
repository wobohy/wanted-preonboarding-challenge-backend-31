package com.wanted.preonboarding_back.domain.product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product_options")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductOptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_group_id")
    private ProductOptionGroupEntity optionGroup;

    @Column(nullable = false)
    private String name;

    @Column(name = "additional_price")
    private BigDecimal additionalPrice;

    private String sku;

    private Integer stock;

    @Column(name = "display_order")
    private Integer displayOrder;

}
