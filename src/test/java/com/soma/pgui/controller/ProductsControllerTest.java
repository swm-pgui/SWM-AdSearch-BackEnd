package com.soma.pgui.controller;

import com.soma.pgui.domain.products.Products;
import com.soma.pgui.domain.products.ProductsRepository;
import com.soma.pgui.dto.products.ProductsSaveRequestDto;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductsControllerTest {

    @Autowired
    ProductsRepository productsRepository;

    @After("")
    public void cleanup(){
        productsRepository.deleteAll();
    }

    @Test
    public void productsCreateTest() throws ParseException {

        // get current month and transpose its type to string
        String testDate = "20210512";

        ProductsSaveRequestDto dto = ProductsSaveRequestDto.builder()
                .name("testName")
                .company("testCompany")
                .address("testAddress")
//                .disposalDate(testDate)
                .disposalCommand("testDisposalCommand")
                .violationStatue("testViolationStatue")
                .violationDetail("testViolationDetail")
                .build();

        productsRepository.save(dto.toEntity());

        List<Products> productsList = productsRepository.findAll();

        Products testProduct = productsList.get(0);

        assertThat(testProduct.getName()).isEqualTo("testName");
        assertThat(testProduct.getCompany()).isEqualTo("testCompany");
        assertThat(testProduct.getAddress()).isEqualTo("testAddress");
//        assertThat(testProduct.getDisposalDate()).isLessThan(Calendar.getInstance());
        assertThat(testProduct.getDisposalCommand()).isEqualTo("testDisposalCommand");
        assertThat(testProduct.getViolationStatue()).isEqualTo("testViolationStatue");
        assertThat(testProduct.getViolationDetail()).isEqualTo("testViolationDetail");

    }

}