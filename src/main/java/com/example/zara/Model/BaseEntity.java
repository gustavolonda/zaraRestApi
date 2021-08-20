
package com.example.zara.Model;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class BaseEntity {
    //Create Date
    @Column( columnDefinition = "timestamp NULL")
    public Timestamp createDate;
    
    //Update Date
    @Column( columnDefinition = "timestamp NULL")
    private Timestamp updateDate;
    
    //Detele Date
    @Column( columnDefinition = "timestamp NULL")
    private Timestamp deteleDate;
}
