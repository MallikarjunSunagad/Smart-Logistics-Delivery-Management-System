package com.User_and_Order_Management_Service.Repository;

import com.User_and_Order_Management_Service.Entites.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
   Page<Orders> findByUserId(Long id, Pageable pageable);
}