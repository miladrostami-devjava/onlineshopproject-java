package com.shop.app.controllers.api.products;

import com.shop.app.entities.products.Feature;
import com.shop.app.helper.ui.ResponseStatus;
import com.shop.app.helper.ui.ServiceResponse;
import com.shop.app.services.product.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feature")
public class FeatureController {
    @Autowired
    private FeatureService service;

    



    @GetMapping("/{id}")
    public ServiceResponse<Feature> search(@PathVariable long id) {
        try {
            Feature result = service.getById(id);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }

    @PostMapping("/add")
    public ServiceResponse<Feature> add(@RequestBody Feature data) {
        try {
            Feature result = service.add(data);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }

    @PutMapping("/update")
    public ServiceResponse<Feature> update(@RequestBody Feature data) {
        try {
            Feature result = service.update(data);
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
