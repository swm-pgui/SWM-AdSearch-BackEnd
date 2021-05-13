package com.soma.pgui.domain.products;

import com.soma.pgui.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Getter
@NoArgsConstructor
@Entity
public class Products{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
    private String company;
    private String address;
    private Calendar disposalDate;
    private String disposalCommand;
    private String violationDetail;
    private String violationStatue;

    @Builder
    public Products(String name, String company, String address, Calendar disposalDate, String disposalCommand, String violationDetail, String violationStatue){
        this.name = name;
        this.company = company;
        this.address = address;
        this.violationDetail = violationDetail;
        this.disposalDate = disposalDate;
        this.disposalCommand = disposalCommand;
        this.violationStatue = violationStatue;
    }

    public void update(String name, String company, String address, Calendar disposalDate, String disposalCommand, String violationDetail, String violationStatue){
        this.name = name;
        this.company = company;
        this.address = address;
        this.violationDetail = violationDetail;
        this.disposalDate = disposalDate;
        this.disposalCommand = disposalCommand;
        this.violationStatue = violationStatue;
    }



}
