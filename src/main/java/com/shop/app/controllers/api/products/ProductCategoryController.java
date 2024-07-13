package com.shop.app.controllers.api.products;

import com.shop.app.entities.products.ProductCategory;
import com.shop.app.entities.site.Slider;
import com.shop.app.helper.ui.ResponseStatus;
import com.shop.app.helper.ui.ServiceResponse;
import com.shop.app.services.product.ProductCategoryService;
import com.shop.app.services.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productCategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService service;

    @GetMapping("")
    public ServiceResponse<ProductCategory> get() {
        try {
            List<ProductCategory> result = service.findAllOrderByItemOrder();
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }



    @GetMapping("/{id}")
    public ServiceResponse<ProductCategory> search(@PathVariable long id) {
        try {
            ProductCategory result = service.getById(id);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }

    @PostMapping("/add")
    public ServiceResponse<ProductCategory> add(@RequestBody ProductCategory data) {
        try {
            ProductCategory result = service.add(data);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }

    @PutMapping("/update")
    public ServiceResponse<ProductCategory> update(@RequestBody ProductCategory data) {
        try {
            ProductCategory result = service.update(data);
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
