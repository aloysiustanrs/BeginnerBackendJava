package com.aloysius.BeginnerBackendJava.repository;

import com.aloysius.BeginnerBackendJava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNameAndAgeAndEmail(String name, int age, String email);
}
