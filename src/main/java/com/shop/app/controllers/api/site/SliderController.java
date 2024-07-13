package com.shop.app.controllers.api.site;

import com.shop.app.entities.site.Slider;
import com.shop.app.helper.ui.ResponseStatus;
import com.shop.app.helper.ui.ServiceResponse;
import com.shop.app.services.site.SliderService;
import com.shop.app.services.site.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slider")
public class SliderController {
    @Autowired
    private SliderService service;

    @GetMapping("")
    public ServiceResponse<Slider> get() {
        try {
            List<Slider> result = service.findAllOrderByItemOrder();
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Slider> getById(@PathVariable long id) {
        try {
            Slider result = service.getById(id);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }

    @PostMapping("/add")
    public ServiceResponse<Slider> add(@RequestBody Slider data) {
        try {
            Slider result = service.add(data);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }

    @PutMapping("/update")
    public ServiceResponse<Slider> update(@RequestBody Slider data) {
        try {
            Slider result = service.update(data);
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
