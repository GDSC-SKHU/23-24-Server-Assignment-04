package gdsc.skhu.jpaexercise.service;

import gdsc.skhu.jpaexercise.domain.Item;
import gdsc.skhu.jpaexercise.dto.ItemSaveReqDto;
import gdsc.skhu.jpaexercise.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public void itemSave(ItemSaveReqDto itemSaveReqDto) {
        Item item = Item.builder()
                .name(itemSaveReqDto.getName())
                .price(itemSaveReqDto.getPrice())
                .build();

        itemRepository.save(item);
    }
}
