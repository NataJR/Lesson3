package com.example.geekbrainsdb.repository;

import com.example.geekbrainsdb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
