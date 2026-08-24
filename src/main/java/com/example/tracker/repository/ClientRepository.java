package com.example.tracker.repository;

import com.example.tracker.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    @Override
    Optional<Client> findById(Integer integer);

    List<Client> findByName(String name);

    List<Client> findByCompany(String company);
}
