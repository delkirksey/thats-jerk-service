package com.del.service.controllers;

import com.del.service.models.MenuItem;
import com.del.service.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MenuItemController {

    private final MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @ModelAttribute
    public void setCORSResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    @PostMapping("menuitem")
    public @ResponseBody ResponseEntity<String> addMenuItem(@RequestBody MenuItem menuItem) {
        menuItemService.save(menuItem);
        return new ResponseEntity<String>(String.format("Menu Item %s created successfully", menuItem.getName()), HttpStatus.CREATED);
    }

    @GetMapping("/menuitems")
    public List<MenuItem> getMenuItems(@RequestParam(value = "menu", required = false, defaultValue = "") String menu) {
        return menuItemService.getMenuItems(menu);
    }

    @PutMapping("menuitem")
    public @ResponseBody ResponseEntity<String> updateMenuItem(@RequestParam Long id, @RequestBody MenuItem menuItem) {
        try {
            menuItemService.update(id, menuItem);
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<String>(String.format("No Menu Item with ID %s could be found", id), HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<String>(String.format("Menu Item with ID: %s updated", id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("menuitem")
    public @ResponseBody ResponseEntity<String> deleteMenuItem(@RequestBody Long id) {
        menuItemService.delete(id);
        return new ResponseEntity<String>(String.format("Menu Item with ID: %s deleted", id), HttpStatus.ACCEPTED);
    }
}
