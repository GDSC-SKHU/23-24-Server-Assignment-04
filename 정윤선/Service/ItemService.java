package Service;

import DTO.ItemDTO;
import Domain.Item;
import Repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());

        return itemRepository.save(item);
    }

    public ItemDTO getItemById(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setPrice(item.getPrice());

        return itemDTO;
    }

    public Item updateItem(Long itemId, ItemDTO updatedItemDTO) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));

        item.setName(updatedItemDTO.getName());
        item.setPrice(updatedItemDTO.getPrice());

        return itemRepository.save(item);
    }

    public void deleteItem(Long itemId) {

        itemRepository.deleteById(itemId);
    }
}
