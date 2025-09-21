package com.User_and_Order_Management_Service.Repository;

import com.User_and_Order_Management_Service.Entites.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
}
