package com.example.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
