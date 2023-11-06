package ItemOrderService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Dto {
    private Integer customerId;
    private Integer itemId;
    private Integer quantity;
}
