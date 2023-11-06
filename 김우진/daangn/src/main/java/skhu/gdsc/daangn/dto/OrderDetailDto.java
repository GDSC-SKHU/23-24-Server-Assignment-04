package skhu.gdsc.daangn.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OrderDetailDto {
    private Long customerId;
    private Long productId;
    private Integer orderQuantity;
}
