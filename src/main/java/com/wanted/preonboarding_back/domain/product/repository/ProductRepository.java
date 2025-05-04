package com.wanted.preonboarding_back.domain.product.repository;

import com.wanted.preonboarding_back.domain.product.entity.ProductEntity;
import com.wanted.preonboarding_back.domain.product.enums.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findById(Long id);
    List<ProductEntity> findAll();
    void deleteById(Long id);
    List<ProductEntity> findByStatus(ProductStatus status);
    List<ProductEntity> findByCategoryId(Long categoryId);
}
