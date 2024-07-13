package com.shop.app.controllers.api.products;

import com.shop.app.entities.products.Size;
import com.shop.app.helper.ui.ResponseStatus;
import com.shop.app.helper.ui.ServiceResponse;
import com.shop.app.services.product.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/size")
public class SizeController {
    @Autowired
    private SizeService service;

    



    @GetMapping("/{id}")
    public ServiceResponse<Size> search(@PathVariable long id) {
        try {
            Size result = service.getById(id);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }

    @PostMapping("/add")
    public ServiceResponse<Size> add(@RequestBody Size data) {
        try {
            Size result = service.add(data);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }

    @PutMapping("/update")
    public ServiceResponse<Size> update(@RequestBody Size data) {
        try {
            Size result = service.update(data);
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
