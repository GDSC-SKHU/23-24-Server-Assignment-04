package com.gdsc.store.service;

import com.gdsc.store.domain.Item;
import com.gdsc.store.dto.ItemDto;
import com.gdsc.store.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public String createItem(ItemDto itemDto) {
        Item item = Item.builder()
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .build();
        itemRepository.save(item);
        return "저장 성공";
    }

    public Item findItemByName(String name) {
        return itemRepository.findItemByName(name)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 상품 이름입니다."));
    }

    public Item findItemById(int id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 상품 ID입니다."));
    }

    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

    @Transactional
    public String updateItem(ItemDto itemDto) {
        Item item = itemRepository.findById(itemDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 상품 ID입니다."));
        item.update(Item.builder()
                .id(itemDto.getId())
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .build());
        return "수정 성공";
    }

    @Transactional
    public String deleteItem(ItemDto itemDto){
        Item item = findItemById(itemDto.getId());
        itemRepository.delete(item);
        return "삭제 성공";
    }
}
