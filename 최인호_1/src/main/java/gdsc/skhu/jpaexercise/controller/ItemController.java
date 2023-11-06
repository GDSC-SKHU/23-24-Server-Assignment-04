package gdsc.skhu.jpaexercise.controller;

import gdsc.skhu.jpaexercise.dto.CustomerSaveReqDto;
import gdsc.skhu.jpaexercise.dto.ItemSaveReqDto;
import gdsc.skhu.jpaexercise.service.CustomerService;
import gdsc.skhu.jpaexercise.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/item/save") //item 정보 저장
    public ResponseEntity<String> customerSave(@RequestBody ItemSaveReqDto itemSaveReqDto) {
        itemService.itemSave(itemSaveReqDto);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

}
