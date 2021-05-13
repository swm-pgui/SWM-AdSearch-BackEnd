package com.soma.pgui.service;

import com.soma.pgui.domain.products.Products;
import com.soma.pgui.domain.products.ProductsRepository;
import com.soma.pgui.dto.products.ProductsResponseDto;
import com.soma.pgui.dto.products.ProductsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    @Transactional
    public Long save(ProductsSaveRequestDto requestDto) throws ParseException {
//        System.out.println(requestDto.toEntity().toString());
        return productsRepository.save(requestDto.toEntity()).getId();
    }

    public ProductsResponseDto findById(Long id) {
        Products entity = productsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다 id=" + id));
        return new ProductsResponseDto(entity);
    }

    public Page<Products> list(int start, int size){
        PageRequest paging = PageRequest.of(start, size);
        Page<Products> results = productsRepository.findAll(paging);
        return results;
    }

    public List<Products> search(String query) {
        return productsRepository.findByNameContainingOrCompanyContaining(query, query);
    }
}

