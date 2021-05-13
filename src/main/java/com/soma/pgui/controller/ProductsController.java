package com.soma.pgui.controller;

import com.soma.pgui.domain.products.Products;
import com.soma.pgui.dto.products.ProductsResponseDto;
import com.soma.pgui.dto.products.ProductsSaveRequestDto;
import com.soma.pgui.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping("/bg1")
    public Products bg1() throws ParseException {
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

    @GetMapping("/list/{start}/{size}")
    public Page<Products> list(@PathVariable int start, @PathVariable int size){
        return productsService.list(start, size);
    }

    @GetMapping("/search")
    public List<Products> search(@RequestParam String query){
        System.out.println(query);
        return productsService.search(query);
    }
}
