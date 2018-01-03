package com.del.service.services;

import com.del.service.models.PressItem;
import com.del.service.repositories.PressItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PressItemService {

    public final PressItemRepository pressItemRepository;

    @Autowired
    public PressItemService(PressItemRepository pressItemRepository) {
        this.pressItemRepository = pressItemRepository;
    }

    public void update(Long id, PressItem pressItem) {

        PressItem itemToUpdate = pressItemRepository.findOne(id);

        if (itemToUpdate == null) throw new EntityNotFoundException();

        itemToUpdate.setTitle(pressItem.getTitle());
        itemToUpdate.setDescription(pressItem.getDescription());
        itemToUpdate.setItemUrl(pressItem.getItemUrl());
        itemToUpdate.setItemType(pressItem.getItemType());
        itemToUpdate.setItemLocation(pressItem.getItemLocation());
        itemToUpdate.setDatePublished(pressItem.getDatePublished());
        itemToUpdate.setFeatured(pressItem.getFeatured());

        pressItemRepository.save(itemToUpdate);
    }
}
