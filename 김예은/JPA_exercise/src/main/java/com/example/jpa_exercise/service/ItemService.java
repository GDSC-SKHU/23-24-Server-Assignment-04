package com.example.jpa_exercise.service;

import com.example.jpa_exercise.domain.Order;
import com.example.jpa_exercise.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import com.example.jpa_exercise.domain.Item;
import com.example.jpa_exercise.dto.ItemDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final OrderService orderService;

    // CREATE
    @Transactional
    public String createItem(ItemDto itemDto) {
        if (itemDto.getOrderName() == null) {
            Item item = createItemWithoutOrder(itemDto);
            itemRepository.save(item);
            return "저장 성공";
        }
        Item item = createItemWithOrder(itemDto);
        itemRepository.save(item);
        return "저장 성공";
    }

    private Item createItemWithoutOrder(ItemDto itemDto) {
        return Item.builder()
                .name(itemDto.getName())
                .build();
    }

    private Item createItemWithOrder(ItemDto itemDto) {
        Order order = findOrderByName(itemDto.getOrderName());
        return Item.builder()
                .name(itemDto.getName())
                .order(order)
                .build();
    }

    // READ
    public ItemDto findItemByNameAsDto(String itemname) {
        return findItemByName(itemname).toDto();
    }

    // UPDATE
    @Transactional
    public String updateItem(ItemDto itemDto) {
        Item item = findItemByName(itemDto.getName());
        if (itemDto.getOrderName() != null) {
            updateItemWithOrder(itemDto, item);
            itemRepository.save(item);
            return "수정 성공";
        }
        updateItemWithoutOrder(itemDto, item);
        itemRepository.save(item);
        return "수정 성공";
    }

    private void updateItemWithOrder(ItemDto itemDto, Item item) {
        Order order = orderService.findOrderByName(itemDto.getOrderName());
        item.update(Item.builder()
                .id(itemDto.getId())
                .name(itemDto.getName())
                .order(order)
                .build());
    }

    private void updateItemWithoutOrder(ItemDto itemDto, Item item) {
        item.update(Item.builder()
                .id(itemDto.getId())
                .name(itemDto.getName())
                .build());
    }

    // DELETE
    @Transactional
    public String deleteItem(String itemname) {
        Item item = findItemByName(itemname);
        itemRepository.delete(item);
        return "삭제 성공";
    }

    private Item findItemByName(String itemname) {
        return itemRepository.findItemByName(itemname)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 물품 이름입니다."));
    }

    private Order findOrderByName(String orderName) {
        return orderService.findOrderByName(orderName);
    }
}
