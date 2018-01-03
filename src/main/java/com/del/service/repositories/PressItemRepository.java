package com.del.service.repositories;

import com.del.service.models.PressItem;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface PressItemRepository extends JpaRepository<PressItem, Long> {

}
