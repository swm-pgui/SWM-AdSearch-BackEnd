package com.soma.pgui.dto.products;

import com.soma.pgui.domain.products.Products;

import java.util.Calendar;

public class ProductsResponseDto {
    private String name;
    private String company;
    private String address;
    private String disposalDate;
    private String disposalCommand;
    private String violationDetail;
    private String violationStatue;

    public ProductsResponseDto (Products entity) {
        this.name = entity.getName();
        this.company = entity.getCompany();
        this.address = entity.getAddress();
        this.disposalDate = entity.getDisposalDate();
        this.disposalCommand = entity.getDisposalCommand();
        this.violationDetail = entity.getViolationDetail();
        this.violationStatue = entity.getViolationStatue();
    }
}
