package com.example.zara.Model;

import java.sql.Timestamp;

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

@Getter
@Setter
@Entity
@Table(name = "price")
public class Price  extends BaseEntity{
    //ID
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_list")
    private Long priceList;
    
    //StartDate 
    @Column(name = "start_date", columnDefinition = "timestamp NULL")
    public Timestamp startDate;
    
    //EndDate
    @Column(name = "end_date", columnDefinition = "timestamp NULL")
    public Timestamp endDate;
    
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
