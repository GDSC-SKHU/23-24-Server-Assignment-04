package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Item;
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
    public String createItem(ItemDto itemDto) {
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

    public ItemDto findItemByIdAsDto(Integer itemId) {
        return findItemById(itemId).toDto();
    }

    @Transactional
    public String updateItem(ItemDto itemDto) {
        Item item = findItemById(itemDto.getId());
        updateItem(itemDto, item);
        itemRepository.save(item);
        return "수정 성공!";
    }

    private void updateItem(ItemDto itemDto, Item item) {
        item.update(Item.builder()
                .name(itemDto.getName())
                .cost(itemDto.getCost())
                .build());
    }

    @Transactional
    public String deleteItem(Integer itemId) {
        Item item = findItemById(itemId);
        itemRepository.delete(item);
        return "삭제 성공!";
    }

    private Item findItemById(Integer itemId) {
        return itemRepository.findItemById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 상품ID입니다."));
    }
}
