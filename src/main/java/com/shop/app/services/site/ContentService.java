package com.shop.app.services.site;

import com.shop.app.entities.site.Content;
import com.shop.app.helper.exceptions.DataNotFoundException;
import com.shop.app.repositories.site.ContentRepository;
import com.shop.app.repositories.site.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {
    @Autowired
    private ContentRepository repository;

    public Content findByKey(String key){
     return repository.findFirstByKey(key);
    }

    public Content getById(long id){
        Optional<Content> data = repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }
public Content add(Content data){
        return repository.save(data);
}
public Content update(Content data) throws DataNotFoundException {

        Content oldData = getById(data.getId());
if (oldData == null){
    throw  new DataNotFoundException("data with id " + " " + data.getId() + " " + " Not Found!");
}
    oldData.setValue(data.getValue());
        return repository.save(oldData);
}

public boolean deleteById(long id) throws DataNotFoundException {
    Content oldData = getById(id);
    if (oldData == null){
        throw  new DataNotFoundException("data with id " + " " + id + " " + " Not Found!");
    }
    repository.deleteById(id);
    return true;
}




}
