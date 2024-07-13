package com.shop.app.services.people;

import com.shop.app.entities.people.User;
import com.shop.app.helper.exceptions.DataNotFoundException;
import com.shop.app.helper.utils.SecurityUtils;
import com.shop.app.repositories.people.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private SecurityUtils securityUtils;
    public User auth(String username, String password) {
        try {
            password = securityUtils.encryptSHA1(password);
        } catch (NoSuchAlgorithmException e) {
            e.getStackTrace();
        }
        //todo problem not response from db
        return repository.findFirstByUsernameAndPassword(username, password);
    }



    public User getByUsername(String username) {
        //todo hash password
        return repository.findFirstByUsername(username);
    }

    public User getById(long id) {
        Optional<User> data = repository.findById(id);
        return data.orElse(null);
    }

    public User add(User data) {
        return repository.save(data);
    }

    public User update(User data) throws DataNotFoundException {

        User oldData = getById(data.getId());
        if (oldData == null) {
            throw new DataNotFoundException("data with id " + " " + data.getId() + " " + " Not Found!");
        }
        oldData.setEmail(data.getEmail());
        oldData.setEnable(data.isEnable());
        oldData.setFirstName(data.getFirstName());
        oldData.setLastName(data.getLastName());
        //todo changePassword()
        // oldData.setPassword(data.getPassword());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        User oldData = getById(id);
        if (oldData == null) {
            throw new DataNotFoundException("data with id " + " " + id + " " + " Not Found!");
        }
        repository.deleteById(id);
        return true;
    }

   /* public User changePassword(long id, String oldPassword, String newPassword) throws DataNotFoundException {
        // todo hashing operation / hash passwords
        try {
            oldPassword = securityUtils.encryptSHA1(oldPassword);
            newPassword = securityUtils.encryptSHA1(newPassword);
        } catch (NoSuchAlgorithmException e) {
            e.getStackTrace();
        }
        User user = getById(id);
        if (user == null) {
            throw new DataNotFoundException("User Not Found!");
        }
        if (!user.getPassword().equals(oldPassword)) {
            throw new DataNotFoundException("invalid old password!");
        }
        user.setPassword(newPassword);
        return repository.save(user);
    }
*/
}
