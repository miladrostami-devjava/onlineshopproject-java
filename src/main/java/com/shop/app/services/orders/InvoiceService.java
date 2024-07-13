package com.shop.app.services.orders;

import com.shop.app.entities.orders.Invoice;
import com.shop.app.helper.exceptions.DataNotFoundException;
import com.shop.app.repositories.orders.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository repository;


public List<Invoice> findByCustomer(long customerId){
return repository.findAllByCustomer(customerId);

}


    public Invoice getById(long id){
        Optional<Invoice> data = repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }
public Invoice add(Invoice data){
        return repository.save(data);
}
public Invoice update(Invoice data) throws DataNotFoundException {

        Invoice oldData = getById(data.getId());
if (oldData == null){
    throw  new DataNotFoundException("data with id " + " " + data.getId() + " " + " Not Found!");
}
        oldData.setPayedDate(data.getPayedDate());

        return repository.save(oldData);
}


public boolean deleteById(long id) throws DataNotFoundException {
    Invoice oldData = getById(id);
    if (oldData == null){
        throw  new DataNotFoundException("data with id " + " " + id + " " + " Not Found!");
    }
    repository.deleteById(id);
    return true;
}






}
