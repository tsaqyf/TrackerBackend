package com.example.tracker.entitys.repos;

import com.example.tracker.entitys.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Long> {
}
