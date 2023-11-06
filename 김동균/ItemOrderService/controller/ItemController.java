package ItemOrderService.controller;

import ItemOrderService.dto.ItemDto;
import ItemOrderService.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/item")
public class ItemController {
    private final ItemService itemService;

    // 상품 등록 메소드
    @PostMapping("/create")
    public String createItem(@RequestBody ItemDto itemDto) {
        return itemService.createItem(itemDto);
    }

    // 1개 상품 정보 조회
    @GetMapping("/{itemId}")
    public ItemDto findItem(@PathVariable("itemId") Integer itemId) {
        return itemService.findItemByItemId(itemId);
    }

    // 전체 상품 조회 메소드
    @GetMapping("/allItem")
    public String findAllItem() {
        return itemService.findAllItemByItemId();
    }

    // 상품 정보 수정 메소드
    @PatchMapping("{itemId}")
    public String updateItemInformation(@PathVariable("itemId") Integer itemId,
                            @RequestBody ItemDto itemDto) {
        String name = itemDto.getItemName();
        Integer price = itemDto.getItemPrice();
        Integer stock = itemDto.getItemStock();

        return itemService.updateItemInformation(itemId, name, price, stock);
    }
}
