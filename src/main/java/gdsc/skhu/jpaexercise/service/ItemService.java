package gdsc.skhu.jpaexercise.service;


import gdsc.skhu.jpaexercise.domain.Item;
import gdsc.skhu.jpaexercise.dto.ItemDto;
import gdsc.skhu.jpaexercise.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public String createItem(ItemDto itemDTO){
        Item item = Item.builder()
                .name(itemDTO.getName())
                .price(itemDTO.getPrice())
                .build();
        itemRepository.save(item);
        return "저장됨";
    }

    public Item findItemByName(String name) {
        return itemRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 물건 이름입니다."));
    }

    public List<Item> itemList(){
        return itemRepository.findAll();
    }

    @Transactional
    public String updateItem(ItemDto itemDTO){
        Item item = itemRepository.findById(itemDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 ID입니다."));
        item.update(Item.builder()
                .id(itemDTO.getId())
                .name(itemDTO.getName())
                .price(itemDTO.getPrice())
                .build());
        return "수정됨";
    }

    @Transactional
    public String deleteItem(ItemDto itemDto){
        Item item = findItemByName(itemDto.getName());
        itemRepository.delete(item);
        return "삭제됨";
    }
}