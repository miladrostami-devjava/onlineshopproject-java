package com.shop.app.controllers.api.site;

import com.shop.app.entities.site.Nav;
import com.shop.app.helper.ui.ResponseStatus;
import com.shop.app.helper.ui.ServiceResponse;
import com.shop.app.services.site.NavService;
import com.shop.app.services.site.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nav")
public class NavController {
    @Autowired
    private NavService service;

    @GetMapping("")
    public ServiceResponse<Nav> get() {
        try {
            List<Nav> result = service.findAllOrderByItemOrder();
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Nav> getById(@PathVariable long id) {
        try {
            Nav result = service.getById(id);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }

    @PostMapping("/add")
    public ServiceResponse<Nav> add(@RequestBody Nav data) {
        try {
            Nav result = service.add(data);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }

    @PutMapping("/update")
    public ServiceResponse<Nav> update(@RequestBody Nav data) {
        try {
            Nav result = service.update(data);
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
