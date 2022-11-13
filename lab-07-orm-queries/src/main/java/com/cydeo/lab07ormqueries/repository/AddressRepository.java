package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {
    //Write a derived query to get all address with a specific customer
    List<Address> findByCustomer_UserName(String username);

    //Write a derived query to get address with a specific street
    List<Address> findByStreet(String street);

    //Write a derived query to get top 3 address with a specific customer email
    List<Address> findTop3ByCustomer_Email(String email);

    //Write a derived query to get all address with a specific customer and name
    List<Address> findAllByCustomer_FirstNameAndCustomer_LastName(String firstName, String lastName);

    //Write a derived query to list all address where the beginning of the street contains the keyword
    List<Address> findAllByStreetStartingWith(String keyword);

    //Write a JPQL query to get all address with a specific customerId
    @Query("SELECT a FROM Address a WHERE a.customer.id = ?1")
    List<Address> findByCustomer_Id(Long id);

}