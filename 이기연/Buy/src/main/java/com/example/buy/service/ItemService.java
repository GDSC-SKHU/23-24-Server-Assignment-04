package com.example.buy.service;

import com.example.buy.domain.Item;
import com.example.buy.dto.ItemDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.buy.repository.ItemRepository;

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
                .id(itemDto.getId())
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .build();
    }

    public ItemDto findItemByIdAsDto(Long itemId) {
        return findItemById(itemId).toDto();
    }

    @Transactional
    public String updateItem(ItemDto itemDto) {
        Item item = findItemById(itemDto.getId());
        updateItem(itemDto, item);
        itemRepository.save(item);
        return "수정 성공";
    }

    private void updateItem(ItemDto itemDto, Item item) {
        item.update(Item.builder()
                .id(itemDto.getId())
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .build());
    }

    @Transactional
    public String deleteItem(Long itemId) {
        Item item = findItemById(itemId);
        itemRepository.delete(item);
        return "삭제 성공!";
    }

    private Item findItemById(Long itemId) {
        return itemRepository.findItemById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 상품ID 입니다."));
    }
}
