package com.shop.app.controllers.api.orders;

import com.shop.app.entities.orders.OrderItem;
import com.shop.app.helper.ui.ResponseStatus;
import com.shop.app.helper.ui.ServiceResponse;
import com.shop.app.services.orders.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orderItem")
public class OrderItemController {
    @Autowired
    private OrderItemService service;





    @GetMapping("/{id}")
    public ServiceResponse<OrderItem> search(@PathVariable long id) {
        try {
            OrderItem result = service.getById(id);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }

    @PostMapping("/add")
    public ServiceResponse<OrderItem> add(@RequestBody OrderItem data) {
        try {
            OrderItem result = service.add(data);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }

    @PutMapping("/update")
    public ServiceResponse<OrderItem> update(@RequestBody OrderItem data) {
        try {
            OrderItem result = service.update(data);
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
