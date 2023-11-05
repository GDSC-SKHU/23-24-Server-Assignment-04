package gdsc.skhu.jpaexercise.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderSaveReqDto {
    private Long customerId;
    private Long itemId;

    public OrderSaveReqDto(Long customerId, Long itemId) {
        this.customerId = customerId;
        this.itemId = itemId;
    }
}
