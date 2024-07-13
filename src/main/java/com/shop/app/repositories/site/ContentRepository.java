package com.shop.app.repositories.site;

import com.shop.app.entities.site.Content;
import com.shop.app.entities.site.Nav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content,Long> {

    Content findFirstByKey(String key);
}
