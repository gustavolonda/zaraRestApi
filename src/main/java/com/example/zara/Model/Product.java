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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product  extends BaseEntity  implements Serializable{
    //ID
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    
    //Name
    @Column(name = "product_name")
    private String productName;
    @OneToMany(mappedBy="product")
    private Set<Price> priceList;
    
}
