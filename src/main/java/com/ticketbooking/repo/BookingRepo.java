package com.ticketbooking.repo;

import com.ticketbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
    @Modifying
    @Query(value = "UPDATE Booking SET status = 'Deactive' WHERE id = ?1", nativeQuery = true)
    void deleteBookingById(String id);

    @Query(value = "SELECT * FROM Booking WHERE schedule_id=?1 AND date=?2", nativeQuery = true)
    List<Booking> searchBookingsByDateAndSchedule_id(long id, String date);
}
