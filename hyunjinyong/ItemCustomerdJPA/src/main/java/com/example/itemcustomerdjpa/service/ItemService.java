package com.example.itemcustomerdjpa.service;

import com.example.itemcustomerdjpa.domain.Item;
import com.example.itemcustomerdjpa.dto.ItemDTO;
import com.example.itemcustomerdjpa.repository.ItemRepository;
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
    public String createItem(ItemDTO itemDTO){
        Item item = Item.builder()
                .name(itemDTO.getName())
                .price(itemDTO.getPrice())
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
    public String updateItem(ItemDTO itemDTO){
      Item item = itemRepository.findById(itemDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 ID입니다."));
      item.update(Item.builder()
                .id(itemDTO.getId())
                .name(itemDTO.getName())
                .price(itemDTO.getPrice())
                .build());
      return "수정 성공";
    }

    //Delete
    @Transactional
    public String deleteItem(ItemDTO itemDTO){
        Item item = findItemByName(itemDTO.getName());
        itemRepository.delete(item);
        return "삭제 성공";
    }
}
