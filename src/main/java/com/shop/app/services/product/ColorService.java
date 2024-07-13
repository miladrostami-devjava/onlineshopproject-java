package com.shop.app.services.product;

import com.shop.app.entities.products.Color;
import com.shop.app.helper.exceptions.DataNotFoundException;
import com.shop.app.repositories.product.ColorRepository;
import com.shop.app.repositories.product.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {
    @Autowired
    private ColorRepository repository;


    public Color getById(long id) {
        Optional<Color> data = repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }

    public List<Color> getAll() {
      return repository.findAll();
    }

    public Color add(Color data) {
        return repository.save(data);
    }

    public Color update(Color data) throws DataNotFoundException {

        Color oldData = getById(data.getId());
        if (oldData == null) {
            throw new DataNotFoundException("data with id " + " " + data.getId() + " " + " Not Found!");
        }
        oldData.setValue(data.getValue());
        oldData.setName(data.getName());

        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        Color oldData = getById(id);
        if (oldData == null) {
            throw new DataNotFoundException("data with id " + " " + id + " " + " Not Found!");
        }
        repository.deleteById(id);
        return true;
    }


}
