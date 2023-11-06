package com.example.buy.controller;

import com.example.buy.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.buy.service.ItemService;

@Service
@RestController
@RequiredArgsConstructor

public class ItemController {
    private final ItemService itemService;

    @PostMapping("/item/new")
    public String createItem(@RequestBody ItemDto itemDto) {
        return itemService.createItem(itemDto);
    }

    @GetMapping("/item/{id}")
    public ItemDto findItem(@PathVariable("id") Long id) {
        return itemService.findItemByIdAsDto(id);
    }

    @PutMapping("/item")
    public String updateItem(@RequestBody ItemDto itemDto) {
        return itemService.updateItem(itemDto);
    }

    @DeleteMapping("/item")
    public String deleteItem(@RequestBody ItemDto itemDto) {
        return itemService.deleteItem(itemDto.getId());
    }
}
