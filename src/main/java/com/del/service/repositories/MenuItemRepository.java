package com.del.service.repositories;

import com.del.service.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface MenuItemRepository  extends JpaRepository<MenuItem, Long> {

    List<MenuItem> getAllByMenu(String menu);
}
