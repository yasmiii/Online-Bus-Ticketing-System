package com.ticketbooking.repo;

import com.ticketbooking.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ScheduleRepo extends JpaRepository<Schedule, Integer> {
    @Modifying
    @Query(value = "UPDATE Schedule SET status = 'Deactive' WHERE id = ?1", nativeQuery = true)
    void deleteScheduleById(String id);
}
