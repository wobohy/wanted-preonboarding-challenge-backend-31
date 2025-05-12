package com.wanted.preonboarding_back.domain.product.service;

import com.wanted.preonboarding_back.domain.product.dto.ProductListResponseDto;
import com.wanted.preonboarding_back.domain.product.dto.ProductRequestDto;
import com.wanted.preonboarding_back.domain.product.entity.ProductEntity;
import com.wanted.preonboarding_back.domain.product.entity.ProductOptionEntity;
import com.wanted.preonboarding_back.domain.product.repository.ProductRepository;
import com.wanted.preonboarding_back.global.common.api.PageInfo;
import com.wanted.preonboarding_back.global.common.api.PaginationResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final EntityManager entityManager;

    public ProductServiceImpl(ProductRepository productRepository, EntityManager entityManager) {
        this.productRepository = productRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public PaginationResponse<ProductListResponseDto> getProductList(ProductRequestDto requestDto) {
        Specification<ProductEntity> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 검색어 조건
            if (StringUtils.hasText(requestDto.getSearch())) {
                String searchPattern = "%" + requestDto.getSearch() + "%";
                predicates.add(cb.like(root.get("name"), searchPattern));
            }

            // 가격 범위 조건
            if (requestDto.getMinPrice() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), requestDto.getMinPrice()));
            }
            if (requestDto.getMaxPrice() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), requestDto.getMaxPrice()));
            }

            // 카테고리 조건
            if (requestDto.getCategory() != null && requestDto.getCategory().length > 0) {
                predicates.add(root.get("category").in(Collections.singletonList(requestDto.getCategory())));
            }

            // 재고 여부 조건
            if (requestDto.getInStock() != null) {
                Join<ProductEntity, ProductOptionEntity> options = root.join("options", JoinType.LEFT);
                if (requestDto.getInStock()) {
                    predicates.add(cb.gt(options.get("stock"), 0));
                } else {
                    predicates.add(cb.equal(options.get("stock"), 0));
                }
            }

            // 판매자 조건
            if (requestDto.getSeller() != null) {
                predicates.add(cb.equal(root.get("seller").get("id"), requestDto.getSeller()));
            }

            // 브랜드 조건
            if (requestDto.getBrand() != null) {
                predicates.add(cb.equal(root.get("brand").get("id"), requestDto.getBrand()));
            }

            // 상태 조건
            if (StringUtils.hasText(requestDto.getStatus())) {
                predicates.add(cb.equal(root.get("status"), requestDto.getStatus()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        PageRequest pageRequest = PageRequest.of(
                Math.max(0, requestDto.getPage()),
                requestDto.getPerPage() == 0 ? 10 : requestDto.getPerPage(),
                getSort(requestDto.getSort())
        );
        Page<ProductEntity> productEntityPage = productRepository.findAll(spec, pageRequest);
        List<ProductListResponseDto> productListResponseDtos = ProductListResponseDto.convertToListResponse(productEntityPage.getContent());

        // DTO 변환 및 반환
        return new PaginationResponse<ProductListResponseDto>(
                productListResponseDtos,
                PageInfo.builder()
                        .totalItems(productEntityPage.getTotalElements())
                        .totalPages(productEntityPage.getTotalPages())
                        .currentPage(requestDto.getPage() + 1)
                        .perPage(requestDto.getPerPage())
                        .build()
        );
    }

    private Sort getSort(String sortStr) {
        String[] parts = sortStr.split(":");
        String field = parts[0];
        Sort.Direction direction = parts.length > 1 && parts[1].equalsIgnoreCase("asc")
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;

        // 필드명 매핑 (예: created_at -> createdAt)
        switch (field) {
            case "created_at" -> field = "createdAt";
            case "price" -> field = "productPriceEntity.price";
            // 필요한 다른 필드들 추가
        }

        return Sort.by(direction, field);
    }
}
