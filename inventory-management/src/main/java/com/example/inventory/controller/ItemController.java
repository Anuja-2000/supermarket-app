package com.example.inventory.controller;

import com.example.inventory.dto.ItemRequest;
import com.example.inventory.dto.ItemResponse;
import com.example.inventory.model.Item;
import com.example.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestBody ItemRequest itemRequest) {
        itemService.createItem(itemRequest);
    }

    @GetMapping("/items")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemResponse> getAllItems() {
        return itemService.getAllItems();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Item updateItem(@RequestBody ItemResponse updatedItem) {
        return itemService.updateItem(updatedItem);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean deleteItem(@PathVariable(value="id") String id) {
        return itemService.deleteItem(id);
    }
}
