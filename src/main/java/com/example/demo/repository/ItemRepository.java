package com.example.demo.repository;

import com.example.demo.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ItemRepository extends CrudRepository<Item, Long> {

    Optional<Item> findByGuid(String guid);
}
