package controllers;

import models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import repositories.MenuRepository;

import java.util.List;

@Controller
public class MenuController {

    private MenuRepository menuRepository;

    @Autowired
    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("/menus")
    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }
}
