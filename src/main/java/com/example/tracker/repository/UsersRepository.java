package com.example.tracker.repository;

import com.example.tracker.entity.Stations;
import com.example.tracker.entity.Users;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
    List<Users> findByUsername(String username);
    List<Users> findByName(String name);
    List<Users> findByStationId(Stations stationId);

}
