package com.del.service.services;

import com.del.service.models.MenuItem;
import com.del.service.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MenuItemService {

    public final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> getMenuItems(String menu) {
        if (!menu.isEmpty()) {

            return menuItemRepository.getAllByMenu(menu);
        }

        return menuItemRepository.findAll();
    }

    public void save(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }

    public void delete(Long id) {
        menuItemRepository.delete(id);
    }

    public void update(Long id, MenuItem menuItem) {

        MenuItem itemToUpdate = menuItemRepository.findOne(id);

        if (itemToUpdate == null) throw new EntityNotFoundException();

        itemToUpdate.setName(menuItem.getName());
        itemToUpdate.setDescription(menuItem.getDescription());
        itemToUpdate.setPrice(menuItem.getPrice());
        itemToUpdate.setType(menuItem.getType());
        itemToUpdate.setMinPrice(menuItem.getMinPrice());
        itemToUpdate.setMaxPrice(menuItem.getMaxPrice());
        itemToUpdate.setMenu(menuItem.getMenu());

        menuItemRepository.save(itemToUpdate);
    }
}
