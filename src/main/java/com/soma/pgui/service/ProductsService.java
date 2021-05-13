package com.soma.pgui.service;


import com.soma.pgui.domain.products.Products;
import com.soma.pgui.domain.products.ProductsRepository;
import com.soma.pgui.dto.products.ProductsResponseDto;
import com.soma.pgui.dto.products.ProductsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

@RequiredArgsConstructor
@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    @Transactional
    public Long save(ProductsSaveRequestDto requestDto) throws ParseException {
        return productsRepository.save(requestDto.toEntity()).getId();
    }

    public ProductsResponseDto findById(Long id) {
        Products entity = productsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다 id=" + id));
        return new ProductsResponseDto(entity);
    }
}
