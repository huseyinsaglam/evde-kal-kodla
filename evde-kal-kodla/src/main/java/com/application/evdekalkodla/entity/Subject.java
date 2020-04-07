package com.application.evdekalkodla.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subject")
@Data // koymamın sebebi subject getter ve setter'ini yaratmak için
@NoArgsConstructor // bu nesnelerin boş bir constructırını yaratıyor
@AllArgsConstructor // bu nesnelerin tüm özelliklerini kullanarak kullanılan bir constructordır
@ToString // özelliklerin ekrana yazılması için tostring metodunu override ediyoruz..
@EqualsAndHashCode // equals ve hash code metotlarını override ediyoruz..
public class Subject extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    @Column(name = "description",length = 1000)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;


    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    @Column(name = "subject_status")
    @Enumerated(EnumType.STRING) // Enum sınıfındaki ögeleri string tipinde tutabiliyoruz..
    private SubjectStatus subjectStatus; // burada görevin takip edecebilecegimiz bir durum oldu..


    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true , fetch = FetchType.LAZY) // birden fazla subject konu bir user'a atanabilir..
    private User assignee;                               // optinal kullanmamızın sebebi bu issue bir kullanıcıya atamasanda olur.. null kalsada olur anlamında



    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true , fetch = FetchType.LAZY) // birden fazla subject konu bir projeye'e atanabilir..
    private Project project;
}
