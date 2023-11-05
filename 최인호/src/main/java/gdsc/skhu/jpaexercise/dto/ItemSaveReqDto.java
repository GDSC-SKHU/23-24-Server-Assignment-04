package gdsc.skhu.jpaexercise.dto;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemSaveReqDto {
    private String name;
    private int price;

    public ItemSaveReqDto(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
