package com.soma.pgui.domain.products;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CancellationException;

@Getter
@NoArgsConstructor
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String company;
    private String address;
    private String disposalDate;
    private String disposalCommand;
    private String violationDetail;
    private String violationStatue;

    @Builder
    public Products(String name, String company, String address, String disposalDate, String disposalCommand, String violationDetail, String violationStatue) throws ParseException {
        if(name.length() > 200){
            name = name.substring(0, 200);
        }
        this.name = name;
        if(company.length() > 200){
            company = company.substring(0, 200);
        }
        this.company = company;
        if(address.length() > 200){
            address = address.substring(0, 200);
        }
        this.address = address;
        if(violationDetail.length() > 200){
            violationDetail = violationDetail.substring(0, 200);
        }
        this.violationDetail = violationDetail;
        if(disposalDate.length() > 200){
            disposalDate = disposalDate.substring(0, 200);
        }
        this.disposalDate = disposalDate;
        if(disposalCommand.length() > 200){
            disposalCommand = disposalCommand.substring(0, 200);
        }
        this.disposalCommand = disposalCommand;
        if(violationStatue == null){
            violationStatue = "abcd";
        }
        if(violationStatue.length() > 200){
            violationStatue = violationStatue.substring(0, 200);
        }
        this.violationStatue = violationStatue;
    }

    public void update(String name, String company, String address, String disposalDate, String disposalCommand,
            String violationDetail, String violationStatue) {
        this.name = name;
        this.company = company;
        this.address = address;
        this.violationDetail = violationDetail;
        this.disposalDate = disposalDate;
        this.disposalCommand = disposalCommand;
        this.violationStatue = violationStatue;
    }


}
