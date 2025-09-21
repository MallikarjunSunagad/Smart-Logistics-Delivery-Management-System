package com.User_and_Order_Management_Service.Repository;

import com.User_and_Order_Management_Service.Entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Object> findByPhoneNumber(String phoneNumber);

    Optional<Object> findByEmail(String email);
}
