package com.shop.app.controllers.api.products;

import com.shop.app.entities.orders.Invoice;
import com.shop.app.entities.products.Product;
import com.shop.app.entities.site.Blog;
import com.shop.app.helper.ui.ResponseStatus;
import com.shop.app.helper.ui.ServiceResponse;
import com.shop.app.services.product.ProductService;
import com.shop.app.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("")
    public ServiceResponse<Product> search(@RequestParam String keyword) {
        try {
            List<Product> result = service.search(keyword);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }

    @GetMapping("/find")
    public ServiceResponse<Product> find(@RequestParam long cid) {
        try {
            List<Product> result = service.findAllByCategory(cid);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Product> search(@PathVariable long id) {
        try {
            Product result = service.getById(id);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }

    @PostMapping("/add")
    public ServiceResponse<Product> add(@RequestBody Product data) {
        try {
            Product result = service.add(data);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }

    @PutMapping("/update")
    public ServiceResponse<Product> update(@RequestBody Product data) {
        try {
            Product result = service.update(data);
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
