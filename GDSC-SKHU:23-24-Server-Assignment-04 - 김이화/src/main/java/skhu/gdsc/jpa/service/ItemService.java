package skhu.gdsc.jpa.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import skhu.gdsc.jpa.domain.Item;
import skhu.gdsc.jpa.dto.ItemDto;
import skhu.gdsc.jpa.repository.ItemRepository;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    //CREATE
    @Transactional
    public String createItem(ItemDto itemDto) {
        Item item = Item.builder()
                .itemId(itemDto.getItemId())
                .build();
        itemRepository.save(item);
        return "저장 성공";
    }

    public Item findByItemId(Integer itemId) {
        return itemRepository.findByItemId(itemId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 상품 번호입니다."));
    }

    @Transactional
    public String updateItem(ItemDto itemDto) {
        Item item = itemRepository.findByItemId(itemDto.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 상품 번호입니다."));
        item.update(Item.builder()
                .itemId(itemDto.getItemId())
                .itemName(itemDto.getItemName())
                .itemPrice(itemDto.getItemPrice())
                .build());
        return "수정 성공";
    }

    @Transactional
    public String deleteItem(ItemDto itemDto) {
        Item item = findByItemId(itemDto.getItemId());
        itemRepository.delete(item);
        return "삭제 성공";
    }
}
