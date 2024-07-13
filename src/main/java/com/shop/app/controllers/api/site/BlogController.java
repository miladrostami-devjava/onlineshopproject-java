package com.shop.app.controllers.api.site;

import com.shop.app.entities.people.User;
import com.shop.app.entities.site.Blog;
import com.shop.app.helper.ui.ResponseStatus;
import com.shop.app.helper.ui.ServiceResponse;
import com.shop.app.helper.uimodels.people.UserVM;
import com.shop.app.services.people.UserService;
import com.shop.app.services.site.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private BlogService service;

    @GetMapping("")
    public ServiceResponse<Blog> search(@RequestParam String keyword) {
        try {
            List<Blog> result = service.search(keyword);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Blog> getById(@PathVariable long id) {
        try {
            Blog result = service.getById(id);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }

    @PostMapping("/add")
    public ServiceResponse<Blog> add(@RequestBody Blog data) {
        try {
            Blog result = service.add(data);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }

    @PutMapping("/update")
    public ServiceResponse<Blog> update(@RequestBody Blog data) {
        try {
            Blog result = service.update(data);
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

    @PutMapping("/increaseVisit/{id}")
    public ServiceResponse<Blog> update(@PathVariable long id) {
        try {
            Blog result = service.increaseVisitCount(id);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }


}
