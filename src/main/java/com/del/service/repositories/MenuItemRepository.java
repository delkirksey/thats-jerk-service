package repositories;

import models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface MenuItemRepository  extends JpaRepository<MenuItem, Long> {
}
