package com.example.utilityserviceprovider.domain;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
@Setter
@Getter
@Entity
public class ServiceRequest {
    /**
     * Creating datafield id, date, doneRequest
     */

    //id   date  ..etc   customer_id  provider_id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @CreationTimestamp
    private String date; //must be checked to be unique (manually)
    private String time;
    private boolean doneRequest;
    private boolean accepted;
    private boolean reviewed;

    private String details;
    private String location;
    //relationships
    @ManyToOne
    MyUser provider;

    @ManyToOne
    MyUser customer;


    /**
     *
     * @Create two Constructors: default Constructor and Constructor passing content and stars
     *
     */

    public ServiceRequest() {
    }


    public ServiceRequest(String details,String location,String date , String time) {
//        this.date = date;
        this.doneRequest = false; //not done when created
        this.accepted=false;    // not accepted when created
        this.reviewed=false;
        this.details=details;
        this.location=location;
        this.date =date;
        this.time=time;

    }

    public boolean isDoneRequest() {
        return doneRequest;
    }


    @Override
    public String toString() {
        return "ServiceRequest{" +
                "doneRequest=" + doneRequest +
                ", accepted=" + accepted +
                ", reviewed=" + reviewed +
                ", details='" + details + '\'' +
                ", location='" + location + '\'' +
                ", provider=" + provider +
                ", customer=" + customer +
                '}';
    }
}

