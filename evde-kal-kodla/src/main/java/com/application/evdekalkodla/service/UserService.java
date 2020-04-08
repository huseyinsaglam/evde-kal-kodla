package com.application.evdekalkodla.service;

import com.application.evdekalkodla.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    public User save(User user); // User verelim kaydetsin sonra geri bize User kaydini geri donsun..

    public User getById(Long id);

    public Page<User> getAllPageable(Pageable pageable); // pageable (sayfalama) seklinde getir butun User leri..

    User getByUsername(String username);
}
