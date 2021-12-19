package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.stereotype.Component;

@Component
public class ItemService {

    public ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public void addItem(String guid, String name) {
        Item item = Item.builder()
                .guid(guid)
                .name(name)
                .build();

        repository.save(item);
    }

    public String getItem(String guid) {
        return repository.findByGuid(guid)
                .map(Item::getName)
                .orElseThrow();

    }
}
