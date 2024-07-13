package com.shop.app.repositories.people;

import com.shop.app.entities.people.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findFirstByUsernameAndPassword(String username,String password);
    User findFirstByUsername(String username);


}
