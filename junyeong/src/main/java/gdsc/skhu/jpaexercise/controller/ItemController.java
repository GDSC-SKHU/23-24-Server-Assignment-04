package gdsc.skhu.jpaexercise.controller;

import gdsc.skhu.jpaexercise.domain.Item;
import gdsc.skhu.jpaexercise.dto.ItemDto;
import gdsc.skhu.jpaexercise.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/item")
    public List<ItemDto> itemList() {
        return itemService.itemList();
    }

    @GetMapping("/item/{name}")
    public ItemDto findItemByName(@PathVariable("name") String name) {
        return itemService.findItemByName(name).toDto();
    }

    @PostMapping("/item/new")
    public String createItem(@RequestBody ItemDto itemDto) {
        return itemService.createItem(itemDto);
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
