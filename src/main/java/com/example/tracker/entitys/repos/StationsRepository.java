package com.example.tracker.entitys.repos;

import com.example.tracker.entitys.domain.Stations;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StationsRepository extends JpaRepository<Stations, Long> {
}
