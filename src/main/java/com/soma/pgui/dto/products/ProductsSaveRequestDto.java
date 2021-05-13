package com.soma.pgui.dto.products;

import com.soma.pgui.domain.products.Products;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Getter
@NoArgsConstructor
public class ProductsSaveRequestDto {
    private String name;
    private String company;
    private String address;
    private Calendar disposalDate;
    private String disposalCommand;
    private String violationDetail;
    private String violationStatue;

    @Builder
    public ProductsSaveRequestDto(String name, String company, String address, Calendar disposalDate, String disposalCommand, String violationDetail, String violationStatue){
        this.name = name;
        this.company = company;
        this.address = address;
        this.disposalDate = disposalDate;
        this.disposalCommand = disposalCommand;
        this.violationDetail = violationDetail;
        this.violationStatue = violationStatue;
    }

    public Products toEntity(){
        return Products.builder()
                .name(name)
                .company(company)
                .address(address)
                .disposalDate(disposalDate)
                .disposalCommand(disposalCommand)
                .violationDetail(violationDetail)
                .violationStatue(violationStatue)
                .build();
    }
}
