package com.application.evdekalkodla.service;

import com.application.evdekalkodla.dto.UserDto;
import com.application.evdekalkodla.entity.User;
import com.application.evdekalkodla.pagination.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    public UserDto save(UserDto user); // User verelim kaydetsin sonra geri bize User kaydini geri donsun..

    public UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable); // pageable (sayfalama) seklinde getir butun User leri..

    UserDto getByUsername(String username);
}
