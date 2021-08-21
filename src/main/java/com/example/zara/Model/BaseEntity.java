
package com.example.zara.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.zara.Util.UtilString;
import com.fasterxml.jackson.annotation.JsonFormat;



@MappedSuperclass
public class BaseEntity {
    //Create Date
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = UtilString.FORMAT_DATE) 
    public Date createDate;
    
    //Update Date
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = UtilString.FORMAT_DATE) 
    private Date updateDate;
    
    //Detele Date
    @Column(name = "detele_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = UtilString.FORMAT_DATE) 
    private Date deteleDate;

    @Column(name = "status")
    private String status ;

    @PrePersist
    public void prePersist(){
        createDate = new Date();
        status = ModelGenericDomain.ACTIVE;
    }
}
