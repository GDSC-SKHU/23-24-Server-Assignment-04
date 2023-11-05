package ItemOrderService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Integer itemId;
    private String itemName;
    private Integer itemPrice;
    private Integer itemStock;
}
