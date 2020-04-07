package com.application.evdekalkodla.repository;

import com.application.evdekalkodla.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;


// Burada hangi tabloya hizmet edecegini söylüyor interface ikincisi o tablonun id ismi nedir
// JpaRepository arka tarafta ekleme silme ve güncelleme metotları yazılmış..
// PagingAndSortingRepository arka tarafta sayfa sayfa sıralama ve bulma metotları yazılmış..
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    // SOLID Prensibi derki her metotda her class da derki bir işi yüklesin
}
