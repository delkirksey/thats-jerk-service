package com.del.service.repositories;

import com.del.service.models.Menu;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface MenuRepository extends JpaRepository<Menu, Long> {

}
