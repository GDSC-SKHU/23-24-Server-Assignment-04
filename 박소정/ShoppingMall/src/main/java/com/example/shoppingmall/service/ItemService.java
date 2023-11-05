package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Customer;
import com.example.shoppingmall.domain.Item;
import com.example.shoppingmall.dto.CustomerDto;
import com.example.shoppingmall.dto.ItemDto;
import com.example.shoppingmall.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public String creatItem(ItemDto itemDto) {
        Item item = createItemData(itemDto);
        itemRepository.save(item);
        return "저장 성공!";
    }

    private Item createItemData(ItemDto itemDto) {
        return Item.builder()
                .name(itemDto.getName())
                .cost(itemDto.getCost())
                .build();
    }

    public ItemDto findItemByNameAsDto(String itemname) {
        return findItemByName(itemname).toDto();
    }

    @Transactional
    public String updateItem(ItemDto itemDto) {
        Item item = findItemByName(itemDto.getName());
        updateItem(itemDto, item);
        itemRepository.save(item);
        return "수정 성공!";
    }

    private void updateItem(ItemDto itemDto, Item item) {
        item.update(Item.builder()
                .id(itemDto.getId())
                .name(itemDto.getName())
                .cost(itemDto.getCost())
                .build());
    }

    private Item findItemByName(String itemname) {
        return itemRepository.findItemByName(itemname)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 상품명입니다."));
    }
}
