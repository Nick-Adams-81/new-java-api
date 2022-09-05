package com.example.newjavaapi.Repositories;

import com.example.newjavaapi.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
