package com.shop.app.repositories.orders;

import com.shop.app.entities.orders.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    @Query("from Invoice where customer.id = :customerId")
    List<Invoice> findAllByCustomer(long customerId);

}
