
package com.example.zara.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@MappedSuperclass
public class BaseEntity {
    //Create Date
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date createDate;
    
    //Update Date
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    
    //Detele Date
    @Column(name = "detele_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deteleDate;

    @PrePersist
    public void prePersist(){
        createDate = new Date();
    }
}
