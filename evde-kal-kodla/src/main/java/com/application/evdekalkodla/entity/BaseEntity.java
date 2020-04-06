package com.application.evdekalkodla.entity;



import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
// Bütün Classlarda ortak oldugunu söylemek için işaretliyoruz.. Diger Classlarda extend edilebiliyor..
@Data // private olan 5 tane özelligin aslında kodun sade durması için otomatik getter ve setter ini oluşturuyor..
public abstract class BaseEntity implements Serializable {


    @Column(name = "createdat")
    @Temporal(TemporalType.TIMESTAMP) // Saat,ay,gün,dakika,milisaniye hepsini tutar
    private Date createdAt; // Bu kaydı kim ekledi ne zaman ekledi.. Kim güncelledi en son..

    @Column(name = "createdby", length = 100)
    private String createdBy; // Kim ekledi

    @Column(name = "uptatedby")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt; // Bu kaydı kim ekledi ne zaman ekledi.. Kim güncelledi en son..

    @Column(name = "updateby", length = 100)
    private String updatedBy; // Kim ekledi

   /* @Column(name = "status")
    private Boolean status; // her kaydın durumuna baksın false ise kayıt aktif degil*/

}
