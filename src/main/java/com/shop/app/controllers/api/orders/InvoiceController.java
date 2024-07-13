package com.shop.app.controllers.api.orders;

import com.shop.app.entities.orders.Invoice;
import com.shop.app.helper.ui.ResponseStatus;
import com.shop.app.helper.ui.ServiceResponse;
import com.shop.app.services.orders.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService service;

    @GetMapping("/find")
    public ServiceResponse<Invoice> find(@RequestParam long cid) {
        try {
            List<Invoice> result = service.findByCustomer(cid);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }



    @GetMapping("/{id}")
    public ServiceResponse<Invoice> search(@PathVariable long id) {
        try {
            Invoice result = service.getById(id);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }

    @PostMapping("/add")
    public ServiceResponse<Invoice> add(@RequestBody Invoice data) {
        try {
            Invoice result = service.add(data);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }

    @PutMapping("/update")
    public ServiceResponse<Invoice> update(@RequestBody Invoice data) {
        try {
            Invoice result = service.update(data);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ServiceResponse<Boolean> delete(@PathVariable long id) {
        try {
            boolean result = service.deleteById(id);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }




}
