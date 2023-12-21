package skhu.gdsc.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skhu.gdsc.jpa.dto.ItemDto;
import skhu.gdsc.jpa.service.ItemService;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/item/new")
    public String createItem(@RequestBody ItemDto itemDto) {
        return itemService.createItem(itemDto);
    }

    @GetMapping("/item/{itemId}")
    public ItemDto findByItemId(@PathVariable("itemId") Integer itemId) {
        return itemService.findByItemId(itemId).toDto();
    }

    @PutMapping("/item")
    public String updateItem(@RequestBody ItemDto itemDto) {
        return itemService.updateItem(itemDto);
    }

    @DeleteMapping("/item")
    public String deleteItem(@RequestBody ItemDto itemDto) {
        return itemService.deleteItem(itemDto);
    }
}

