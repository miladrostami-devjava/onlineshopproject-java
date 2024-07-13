package com.shop.app.repositories.site;

import com.shop.app.entities.site.Nav;
import com.shop.app.entities.site.Slider;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SliderRepository extends JpaRepository<Slider,Long> {

    List<Slider> findAllByEnableIsTrue(Sort sort);
}
