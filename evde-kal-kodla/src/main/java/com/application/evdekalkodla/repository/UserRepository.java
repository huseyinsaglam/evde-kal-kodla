package com.application.evdekalkodla.repository;

import com.application.evdekalkodla.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
