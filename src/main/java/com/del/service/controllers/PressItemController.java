package com.del.service.controllers;

import com.del.service.models.PressItem;
import com.del.service.repositories.PressItemRepository;
import com.del.service.services.PressItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class PressItemController {

    private final PressItemService pressItemService;
    private final PressItemRepository pressItemRepository;

    @Autowired
    public PressItemController(PressItemService pressItemService, PressItemRepository pressItemRepository) {
        this.pressItemService = pressItemService;
        this.pressItemRepository = pressItemRepository;
    }

    @ModelAttribute
    public void setCORSResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    @PostMapping("pressitem")
    public @ResponseBody ResponseEntity<String> addPressItem(@RequestBody PressItem pressItem) {
        pressItemRepository.save(pressItem);
        return new ResponseEntity<String>(String.format("Press Item %s created successfully", pressItem.getTitle()), HttpStatus.CREATED);
    }

    @GetMapping("pressitems")
    public List<PressItem> getPressItems() {
        return pressItemRepository.findAll();
    }

    @PutMapping("pressitem")
    public @ResponseBody ResponseEntity<String> updatePressItem(@RequestParam Long id, @RequestBody PressItem pressItem) {
        try {
            pressItemService.update(id, pressItem);
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<String>(String.format("No Press Item with ID %s could be found", id), HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<String>(String.format("Press Item with ID: %s updated", id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("pressitem")
    public @ResponseBody ResponseEntity<String> deletePressItem(@RequestBody Long id) {
        pressItemRepository.delete(id);
        return new ResponseEntity<String>(String.format("Press Item with ID: %s deleted", id), HttpStatus.ACCEPTED);
    }
}
