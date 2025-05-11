package com.wanted.preonboarding_back.domain.product.repository;

import com.wanted.preonboarding_back.domain.product.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {
    @EntityGraph(attributePaths = {"brandEntity", "sellerEntity"})
    Page<ProductEntity> findAll(Specification<ProductEntity> spec, Pageable pageable);
    void deleteById(Long id);
}
