package com.example.zara.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "brand")
public class Brand extends BaseEntity{
    //ID
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long brandId;
    
    //Name
    @Column(name = "brand_name")
    private String brandName;
    @OneToMany(mappedBy="brand")
    private Set<Price> priceList;
}
