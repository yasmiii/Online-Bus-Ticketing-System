package com.ticketbooking.repo;

import com.ticketbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User>  findById(int userId);
    Optional<User> findByEmailOrNicOrMobile(String email, String nic, String mobile);
    Optional<User> findByEmailAndPassword(String email, String password);
}
