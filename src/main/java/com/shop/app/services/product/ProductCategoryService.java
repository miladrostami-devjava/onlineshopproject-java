package com.shop.app.services.product;

import com.shop.app.entities.products.ProductCategory;
import com.shop.app.helper.exceptions.DataNotFoundException;
import com.shop.app.repositories.product.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository repository;

    public List<ProductCategory> findAllOrderByItemOrder(){
     return repository.findAllByEnableIsTrue(Sort.by("id"));
    }

    public ProductCategory getById(long id){
        Optional<ProductCategory> data = repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }
public ProductCategory add(ProductCategory data){
        return repository.save(data);
}
public ProductCategory update(ProductCategory data) throws DataNotFoundException {

        ProductCategory oldData = getById(data.getId());
if (oldData == null){
    throw  new DataNotFoundException("data with id " + " " + data.getId() + " " + " Not Found!");
}
        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setEnable(data.isEnable());
        oldData.setImage(data.getImage());

        return repository.save(oldData);
}

public boolean deleteById(long id) throws DataNotFoundException {
    ProductCategory oldData = getById(id);
    if (oldData == null){
        throw  new DataNotFoundException("data with id " + " " + id + " " + " Not Found!");
    }
    repository.deleteById(id);
    return true;
}




}
