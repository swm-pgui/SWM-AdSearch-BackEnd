package com.soma.pgui.dto.products;

import com.soma.pgui.domain.products.Products;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.util.Calendar;

@Getter
@NoArgsConstructor
public class ProductsSaveRequestDto {
    private String name;
    private String company;
    private String address;
    private String disposalDate;
    private String disposalCommand;
    private String violationDetail;
    private String violationStatue;

    @Builder
    public ProductsSaveRequestDto(String name, String company, String address, String disposalDate, String disposalCommand, String violationDetail, String violationStatue){
        this.name = name;
        this.company = company;
        this.address = address;
        this.disposalDate = disposalDate;
        this.disposalCommand = disposalCommand;
        this.violationDetail = violationDetail;
        this.violationStatue = violationStatue;
    }

    public Products toEntity() throws ParseException {
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

    @Override
    public String toString() {
        return "name : " + name + ", company : " + company + ", address : " + address + ", violationDetail : " + violationDetail
                + ", disposaldate : " + disposalDate + ", disposalCommand : " + disposalCommand + ", violationStatue : " + violationStatue;
    }
}
