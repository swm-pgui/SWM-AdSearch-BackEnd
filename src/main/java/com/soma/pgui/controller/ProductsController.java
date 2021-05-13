package com.soma.pgui.controller;

import com.soma.pgui.domain.products.Products;
import com.soma.pgui.dto.products.ProductsResponseDto;
import com.soma.pgui.dto.products.ProductsSaveRequestDto;
import com.soma.pgui.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping("/bg1")
    public Products bg1(){
        ProductsSaveRequestDto productsSaveRequestDto = ProductsSaveRequestDto.builder().
                name("name1")
                .company("company1")
                .build();

        return productsSaveRequestDto.toEntity();
    }

    @GetMapping("/products/{id}")
    public ProductsResponseDto findById(@RequestParam Long id) {
        return productsService.findById(id);
    }
}
