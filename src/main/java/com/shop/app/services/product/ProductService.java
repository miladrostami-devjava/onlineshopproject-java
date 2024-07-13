package com.shop.app.services.product;

import com.shop.app.entities.products.Product;
import com.shop.app.entities.site.Blog;
import com.shop.app.helper.exceptions.DataNotFoundException;
import com.shop.app.repositories.product.ProductRepository;
import com.shop.app.repositories.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAllByCategory(long categoryId) {
        return repository.findAllByCategory(categoryId);
    }
    public List<Product> search(String keyword) {
        return repository.findAllByEnableIsTrueAndTitleContainsOrDescriptionContains(keyword);
    }
    public Product getById(long id) {
        Optional<Product> data = repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }

    public Product add(Product data) {
        return repository.save(data);
    }

    public Product update(Product data) throws DataNotFoundException {

        Product oldData = getById(data.getId());
        if (oldData == null) {
            throw new DataNotFoundException("data with id " + " " + data.getId() + " " + " Not Found!");
        }
        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setEnable(data.isEnable());
        oldData.setImage(data.getImage());
        oldData.setExists(data.isExists());
        oldData.setPrice(data.getPrice());
        oldData.setColors(data.getColors());
     //   oldData.setCategory(data.getCategory());
        oldData.setFeatures(data.getFeatures());
        oldData.setSizes(data.getSizes());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        Product oldData = getById(id);
        if (oldData == null) {
            throw new DataNotFoundException("data with id " + " " + id + " " + " Not Found!");
        }
        repository.deleteById(id);
        return true;
    }

    public Product increaseVisitCount(long id) throws DataNotFoundException {

        Product oldData = getById(id);
        if (oldData == null){
            throw  new DataNotFoundException("data with id " + " " + id + " " + " Not Found!");
        }
        oldData.setVisitCount(oldData.getVisitCount() + 1);

        return repository.save(oldData);
    }



}
