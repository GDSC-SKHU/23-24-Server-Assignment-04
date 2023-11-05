package ItemOrderService.service;

import ItemOrderService.domain.Item;
import ItemOrderService.dto.ItemDto;
import ItemOrderService.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    // 상품 등록 메소드
    @Transactional
    public String createItem(ItemDto itemDto) {
        Item item = Item.builder()
                .itemId(itemDto.getItemId())
                .itemName(itemDto.getItemName())
                .itemPrice(itemDto.getItemPrice())
                .itemStock(itemDto.getItemStock())
                .build();

        itemRepository.save(item);
        return "상품이 등록되었습니다.";
    }

    // 1개 상품 정보 조회 메소드
    public ItemDto findItemByItemId(Integer itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다"));

        return  ItemDto.builder()
                .itemId(item.getItemId())
                .itemName(item.getItemName())
                .itemPrice(item.getItemPrice())
                .itemStock(item.getItemStock())
                .build();
    }

    // 전체 상품 조회 메소드
    public String findAllItemByItemId() {
        List<Item> itemList = new ArrayList<>(itemRepository.findAll());
        for (Item item : itemList) {
            return "상품 ID : " + item.getItemId() +  ", 이름 : " + item.getItemName() + ", 가격 : " +
                    item.getItemPrice() + ", 재고 : " +
                    + item.getItemStock() + "\n";
        }
        return "";
    }

    // 상품 정보 수정 메소드
    @Transactional
    public String updateItemInformation(Integer itemId, String itemName, Integer itemPrice, Integer itemStock) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다"));
        item.updateItemInformation(itemName, itemPrice, itemStock);
        return "수정이 완료되었습니다";
    }
}
