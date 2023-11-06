package com.gdsc.store.controller;

import com.gdsc.store.domain.Item;
import com.gdsc.store.dto.ItemDto;
import com.gdsc.store.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/item/new")
    public String createItem(@RequestBody ItemDto itemDto){
        return itemService.createItem(itemDto);
    }

    @GetMapping("/item/{id}")
    public ItemDto findItemById(@PathVariable("id") int id){
        return itemService.findItemById(id).toDto();
    }

    @GetMapping("/item")
    public List<Item> findAllItem(){
        return itemService.findAllItem();
    }

    @PutMapping("/item")
    public String updateItem(@RequestBody ItemDto itemDto){
        return itemService.updateItem(itemDto);
    }

    @DeleteMapping("/item")
    public String deleteItem(@RequestBody ItemDto itemDto){
        return itemService.deleteItem(itemDto);
    }
}
