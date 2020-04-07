package com.application.evdekalkodla.repository;

import com.application.evdekalkodla.entity.SubjectHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectHistoryRepository extends JpaRepository<SubjectHistory,Long> {

    List<SubjectHistory> getByIssueIdOrderById(Long id);

    // extends JpaRepository<SubjectHistory,Long> burada spring boot data jpa extends ederek arka tarafta
    // ekleme,güncelleme , silme , vb.. olayları extends olmuş oluyoruz..
    // extends JpaRepository<hangi entity gösterecek isek name,entity id dönüş tipi>
}
