package com.example.itemcustomerdjpa.controller;


import com.example.itemcustomerdjpa.domain.Item;

import com.example.itemcustomerdjpa.dto.ItemDTO;
import com.example.itemcustomerdjpa.service.ItemService;
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
    public ItemDTO findItemByName(@PathVariable("name") String name){
        return itemService.findItemByName(name).toDto();
    }

    @PostMapping("/item/new")
    public  String createItem(@RequestBody ItemDTO itemDTO){
        return  itemService.createItem((itemDTO));
    }

    @PutMapping("/item")
    public String updateItem(@RequestBody ItemDTO itemDTO){
        return  itemService.updateItem(itemDTO);
    }

    @DeleteMapping("/item")
    public String deleteItem(@RequestBody ItemDTO itemDTO){
        return itemService.deleteItem(itemDTO);
    }
}
