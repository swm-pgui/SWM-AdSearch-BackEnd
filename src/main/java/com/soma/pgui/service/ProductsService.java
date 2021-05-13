package com.soma.pgui.service;


import com.soma.pgui.domain.products.ProductsRepository;
import com.soma.pgui.dto.products.ProductsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    @Transactional
    public Long save(ProductsSaveRequestDto requestDto){
        return productsRepository.save(requestDto.toEntity()).getId();
    }
}
