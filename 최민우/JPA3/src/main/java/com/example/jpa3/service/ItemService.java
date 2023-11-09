package com.example.jpa3.service;

import com.example.jpa3.domain.Item;
import com.example.jpa3.dto.ItemDto;
import com.example.jpa3.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    //Create
    @Transactional
    public String createItem(ItemDto itemDto){
        Item item = Item.builder()
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .build();
        itemRepository.save(item);
        return "저장 성공";
    }

    //Read
    public Item findItemByName(String name) {
        return itemRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 물건명입니다."));
    }

    public List<Item> itemList(){
        return itemRepository.findAll();
    }

    //Update
    @Transactional
    public String updateItem(ItemDto itemDto){
        Item item = itemRepository.findById(itemDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 ID입니다."));
        item.update(Item.builder()
                .id(itemDto.getId())
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .build());
        return "수정 성공";
    }

    //Delete
    @Transactional
    public String deleteItem(ItemDto itemDto){
        Item item = findItemByName(itemDto.getName());
        itemRepository.delete(item);
        return "삭제 성공";
    }
}