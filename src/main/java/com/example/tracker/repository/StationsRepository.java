package com.example.tracker.repository;

import com.example.tracker.entity.Stations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.UUID;

public interface StationsRepository extends JpaRepository<Stations, UUID> {
    List<Stations> findByCodeOrName(char code, String name);

}
