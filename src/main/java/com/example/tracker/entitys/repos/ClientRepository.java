package com.example.tracker.entitys.repos;

import com.example.tracker.entitys.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
}
