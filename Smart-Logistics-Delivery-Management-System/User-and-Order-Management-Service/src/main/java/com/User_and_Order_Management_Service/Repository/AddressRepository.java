package com.User_and_Order_Management_Service.Repository;

import com.User_and_Order_Management_Service.Entites.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
