package com.example.orderitem.controller;

import com.example.orderitem.domain.Item;
import com.example.orderitem.item.dto.AddItemRequest;
import com.example.orderitem.item.dto.ItemResponse;
import com.example.orderitem.item.dto.UpdateItemRequest;
import com.example.orderitem.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemResponse> createItem(@RequestBody @Validated AddItemRequest addItemRequest) {
        Item item = itemService.saveItem(addItemRequest);
        return ResponseEntity.ok(ItemResponse.createInstance(item));
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponse> findById(@PathVariable Long itemId) {
        Item findItem = itemService.findById(itemId);
        return ResponseEntity.ok(ItemResponse.createInstance(findItem));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Item> items = itemService.findItems();
        List<ItemResponse> collect = items.stream().map(ItemResponse::createInstance).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }

    @PatchMapping("/{itemId}")
    public ResponseEntity<ItemResponse> itemUpdate(@PathVariable(name = "itemId") Long itemId, @RequestBody @Validated UpdateItemRequest updateItemRequest) {
        itemService.updateItem(itemId, updateItemRequest);
        Item findItem = itemService.findById(itemId);
        return ResponseEntity.ok(ItemResponse.createInstance(findItem));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<?> itemDelete(@PathVariable(name = "itemId") Long itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
