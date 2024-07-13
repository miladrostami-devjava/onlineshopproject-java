package com.shop.app.services.site;

import com.shop.app.entities.site.Blog;
import com.shop.app.helper.exceptions.DataNotFoundException;
import com.shop.app.repositories.site.BlogRepository;
import com.shop.app.repositories.site.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository repository;

    public List<Blog> search(String keyword){
     return repository.findAllByTitleContainsOrDescriptionContains(keyword);
    }

    public Blog getById(long id){
        Optional<Blog> data = repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }
public Blog add(Blog data) throws Exception {
        if (data.getTitle() == null && data.equals("")){
            throw new Exception("Please Fill Title Field!");
        }
        return repository.save(data);
}
public Blog update(Blog data) throws DataNotFoundException {

        Blog oldData = getById(data.getId());
if (oldData == null){
    throw  new DataNotFoundException("data with id " + " " + data.getId() + " " + " Not Found!");
}
        oldData.setTitle(data.getTitle());
        oldData.setDescription(data.getDescription());
        oldData.setImage(data.getImage());
        oldData.setStatus(data.getStatus());
        return repository.save(oldData);
}


public boolean deleteById(long id) throws DataNotFoundException {
    Blog oldData = getById(id);
    if (oldData == null){
        throw  new DataNotFoundException("data with id " + " " + id + " " + " Not Found!");
    }
    repository.deleteById(id);
    return true;
}

    public Blog increaseVisitCount(long id) throws DataNotFoundException {

        Blog oldData = getById(id);
        if (oldData == null){
            throw  new DataNotFoundException("data with id " + " " + id + " " + " Not Found!");
        }
        oldData.setVisitCount(oldData.getVisitCount() + 1);

        return repository.save(oldData);
    }




}
