package com.example.zara.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
// Define a sequence - might also be in another class:
@SequenceGenerator(name="seq", initialValue=35455, allocationSize=100)
public class Product  extends BaseEntity  implements Serializable{
    //ID
    @Id
	// Use the sequence that is defined above:
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @Column(name = "product_id")
    private Long productId;
    
    //Name
    @Column(name = "product_name")
    private String productName;
    
    @JsonIgnore
    @OneToMany(mappedBy="product")
    private Set<Price> priceList;
    
}
