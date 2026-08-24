package com.example.tracker.repository;

import com.example.tracker.entity.Stations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface StationsRepository extends JpaRepository<Stations,Integer> {
    List<Stations> findByCodeOrName(@Nullable char code, @Nullable String name);

}
