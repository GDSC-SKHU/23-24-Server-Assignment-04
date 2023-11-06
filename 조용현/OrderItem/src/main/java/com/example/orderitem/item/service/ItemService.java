package com.example.orderitem.item.service;

import com.example.orderitem.domain.Item;
import com.example.orderitem.item.dto.AddItemRequest;
import com.example.orderitem.item.dto.UpdateItemRequest;
import com.example.orderitem.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Item saveItem(AddItemRequest addItemRequest){
        return itemRepository.save(addItemRequest.toEntity());
    }

    @Transactional
    public void updateItem(Long itemId, UpdateItemRequest updateItemRequest){
        Item findItem = itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("찾으려는 상품이 없습니다."));
        findItem.updateItem(updateItemRequest.name(), updateItemRequest.price(), updateItemRequest.stockQuantity());
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findById(Long itemId){
        return itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("찾으려는 상품이 없습니다."));
    }

    @Transactional
    public void deleteItem(Long itemId){
        Item findItem = itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("찾으려는 상품이 없습니다."));
        itemRepository.delete(findItem);
    }
}
