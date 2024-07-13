package com.shop.app.repositories.people;

import com.shop.app.entities.people.Customer;
import com.shop.app.entities.people.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
