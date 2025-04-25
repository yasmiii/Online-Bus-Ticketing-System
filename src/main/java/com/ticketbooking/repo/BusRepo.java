package com.ticketbooking.repo;

import com.ticketbooking.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusRepo extends JpaRepository<Bus, Integer> {
    @Modifying
    @Query(value = "UPDATE Bus SET status = 'Deactive' WHERE id = ?1", nativeQuery = true)
    void deleteBusById(String id);

    @Query(value = "SELECT * FROM Bus WHERE owner_id = ?1", nativeQuery = true)
    List<Bus> getByOwnerId(int id);
}
