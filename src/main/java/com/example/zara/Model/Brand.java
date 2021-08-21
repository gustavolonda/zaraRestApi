package com.example.zara.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "brand")
public class Brand extends BaseEntity  implements Serializable{
    //ID
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long brandId;
    
    //Name
    @Column(name = "brand_name")
    private String brandName;

    @JsonIgnore
    @OneToMany(mappedBy="brand")
    private Set<Price> priceList;
}
