package com.example.inventory.service;

import com.example.inventory.dto.ItemRequest;
import com.example.inventory.dto.ItemResponse;
import com.example.inventory.model.Item;
import com.example.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(ItemRequest itemRequest){
        UUID id = UUID.randomUUID();
        Item item = new  Item(id.toString(),
                itemRequest.getName(),
                itemRequest.getDescription(),
                itemRequest.getQuantity(),
                itemRequest.getPrice(),
                itemRequest.getAddedBy(),
                new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()));

        itemRepository.save(item);
        System.out.println("item "+item.getId()+"is saved");
    }

    public List<ItemResponse> getAllItems(){
        List<Item> items = itemRepository.findAll();
        return items.stream().map(this::mapToItemResponse).toList();
    }

    public ItemResponse mapToItemResponse(Item item){
        return new ItemResponse(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getQuantity(),
                item.getPrice(),
                item.getAddedBy(),
                item.getLastUpdated()
        );
    }
}
