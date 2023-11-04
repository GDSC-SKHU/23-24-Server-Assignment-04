package skhu.gdsc.daangn.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderDto {
    private Long orderId;
    private String customerName;
    private String customerAddress;
    private long totalPurchasePrice;
    private ProductDto productDto;
}
