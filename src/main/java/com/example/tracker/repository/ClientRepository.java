package com.example.tracker.repository;

import com.example.tracker.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client,UUID> {

    @Override
    Optional<Client> findById(UUID integer);

    List<Client> findByName(String name);

    List<Client> findByCompany(String company);
}
