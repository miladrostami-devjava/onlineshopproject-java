package com.shop.app.services.site;

import com.shop.app.entities.site.Nav;
import com.shop.app.entities.site.Nav;
import com.shop.app.helper.exceptions.DataNotFoundException;
import com.shop.app.repositories.site.NavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NavService {
    @Autowired
    private NavRepository repository;

    public List<Nav> findAllOrderByItemOrder(){
     return repository.findAllByEnableIsTrue(Sort.by("itemOrder"));
    }

    public Nav getById(long id){
        Optional<Nav> data = repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }
public Nav add(Nav data){
        return repository.save(data);
}
public Nav update(Nav data) throws DataNotFoundException {

        Nav oldData = getById(data.getId());
if (oldData == null){
    throw  new DataNotFoundException("data with id " + " " + data.getId() + " " + " Not Found!");
}
        oldData.setTitle(data.getTitle());
        oldData.setEnable(data.isEnable());
        oldData.setItemOrder(data.getItemOrder());
        oldData.setLink(data.getLink());
        return repository.save(oldData);
}

public boolean deleteById(long id) throws DataNotFoundException {
    Nav oldData = getById(id);
    if (oldData == null){
        throw  new DataNotFoundException("data with id " + " " + id + " " + " Not Found!");
    }
    repository.deleteById(id);
    return true;
}




}
