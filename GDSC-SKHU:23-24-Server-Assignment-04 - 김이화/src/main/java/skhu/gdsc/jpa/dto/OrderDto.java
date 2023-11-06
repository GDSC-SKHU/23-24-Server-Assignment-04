package skhu.gdsc.jpa.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer orderId;
    private String orderDate;
    private Integer customerId;
    private Integer itemId;

}
