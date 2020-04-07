package com.application.evdekalkodla.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users") /*perfonmans icin bunu veriyoruz*/
@Data // koymamın sebebi user getter ve setter'ini yaratmak için
@NoArgsConstructor // bu nesnelerin boş bir constructırını yaratıyor
@AllArgsConstructor // bu nesnelerin tüm özelliklerini kullanarak kullanılan bir constructordır
@ToString // özelliklerin ekrana yazılması için tostring metodunu override ediyoruz..
@EqualsAndHashCode // equals ve hash code metotlarını override ediyoruz..
public class User extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", length = 100) // unique username ile kisi birden fazla kayıt olmasın..
    private String username;

    @Column(name = "pwd", length = 200)
    private String password;

    @Column(name = "name_surname", length = 200)
    private String nameSurname;

    @Column(name = "email", length = 100)
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY) // bir user'a birden fazla konu atanabilir..
    private List<Subject> subjects;

}
