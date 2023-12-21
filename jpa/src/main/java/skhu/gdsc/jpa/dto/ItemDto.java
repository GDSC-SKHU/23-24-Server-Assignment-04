package skhu.gdsc.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Integer itemId;
    private String itemName;
    private Integer itemPrice;
    private List<OrderDto> orders = new ArrayList<>();

}
