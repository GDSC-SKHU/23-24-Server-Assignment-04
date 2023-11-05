package gdsc.skhu.jpaexercise.dto;

import gdsc.skhu.jpaexercise.domain.Customer;
import gdsc.skhu.jpaexercise.domain.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderResDto {
    private Long itemId;
    private String name;
    private int price;

    public OrderResDto(Long itemId, String name, int price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }
}
