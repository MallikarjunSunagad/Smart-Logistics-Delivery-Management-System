package com.User_and_Order_Management_Service.Repository;

import com.User_and_Order_Management_Service.Entites.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Long> {
}
