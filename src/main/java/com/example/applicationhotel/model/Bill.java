package com.example.applicationhotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bill")
    private Integer bill_id;
    private Float amount;
    @Temporal(TemporalType.DATE)
    @Column(name = "paymentdate")
    private Date paymentdate;
    private String payment_method;
    private String payment_name;
    @ManyToOne
    @JoinColumn(name = "id")
    private Guest guest;
    public Bill(Integer bill_id){
        this.bill_id= bill_id;
    }
    public Bill() {}
}