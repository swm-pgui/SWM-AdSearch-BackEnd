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
    public Products(String name, String company, String address, String disposalDate, String disposalCommand, String violationDetail, String violationStatue) throws ParseException {
        this.name = name;
        this.company = company;
        this.address = address;
        this.violationDetail = violationDetail;
//        Calendar tmp = Calendar.getInstance();
//        tmp.set(Integer.parseInt(disposalDate.substring(0, 4)), Integer.parseInt(disposalDate.substring(4, 6)) - 1, Integer.parseInt(disposalDate.substring(6, 8)));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = sdf.parse(disposalDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        this.disposalDate = cal;
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
