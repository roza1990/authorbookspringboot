package com.example.authorbook.repository;

import com.example.authorbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
