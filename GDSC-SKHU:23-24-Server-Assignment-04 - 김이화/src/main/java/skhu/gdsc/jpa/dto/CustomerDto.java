package skhu.gdsc.jpa.dto;

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
public class CustomerDto {
    private  Integer customerId;
    private String customerName;
    private String customerAddress;
    private List<OrderDto> orders = new ArrayList<>();
}
