package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/item")
public class ItemController {

    private Logger logger = LoggerFactory.getLogger(ItemController.class);

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String getItem(@RequestParam String guid) {
        String item;

        try {
            item = itemService.getItem(guid);
        } catch (NoSuchElementException e) {
            logger.info("No item for guid: " + guid);
            item = "No value for given guid";
        }

        logger.info("Returning item: " + item);
        return item;
    }

    @PostMapping
    public void addItem(@RequestBody Item item) {
        logger.info("Adding item, guid: " + item.getGuid() + ", name: " + item.getName());
        itemService.addItem(item.getGuid(), item.getName());
    }
}
