package ItemOrderService.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer orderId;
    private List<ItemDto> items = new ArrayList<>();
    private List<CustomerDto> customers = new ArrayList<>();
    private Integer orderAmount;
    private String orderDate;
}
