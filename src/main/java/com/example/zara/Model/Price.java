package com.example.zara.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Getter
@Setter
@Entity
@Table(name = "price")
public class Price  extends BaseEntity  implements Serializable{
    //ID
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_list")
    private Long priceList;
    
    //StartDate 
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date startDate;
    
    //EndDate
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date endDate;
    
    //Brand : foreign key
    @ManyToOne
    @JoinColumn(name="brand_id", nullable=false)
    private Brand brand;

    //Product : foreign key
    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
    
    //Priority
    private int priority;

    //Price
    private double price;
    
    //Curr
    private String curr;
    
}
