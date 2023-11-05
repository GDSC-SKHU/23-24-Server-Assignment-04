package com.example.jpa3.controller;

import com.example.jpa3.domain.Item;
import com.example.jpa3.dto.ItemDto;
import com.example.jpa3.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/item")
    public List<Item> itemList(){
        return itemService.itemList();
    }

    @GetMapping("/item/{name}")
    public ItemDto findItemByName(@PathVariable("name") String name){
        return itemService.findItemByName(name).toDto();
    }

    @PostMapping("/item/new")
    public  String createItem(@RequestBody ItemDto itemDto){
        return  itemService.createItem((itemDto));
    }

    @PutMapping("/item")
    public String updateItem(@RequestBody ItemDto itemDto){
        return  itemService.updateItem(itemDto);
    }

    @DeleteMapping("/item")
    public String deleteItem(@RequestBody ItemDto itemDto){
        return itemService.deleteItem(itemDto);
    }
}