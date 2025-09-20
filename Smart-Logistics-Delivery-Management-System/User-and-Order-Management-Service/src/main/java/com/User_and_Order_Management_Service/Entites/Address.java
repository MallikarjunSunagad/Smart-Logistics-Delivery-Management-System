package com.User_and_Order_Management_Service.Entites;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mapping_id")
    private Long id;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    @OneToMany(mappedBy = "address")
    private Orders order;

}
