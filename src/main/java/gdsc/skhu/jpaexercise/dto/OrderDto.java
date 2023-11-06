package gdsc.skhu.jpaexercise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderDto {
    private Integer id;
    private String customerName;
    private String itemName;
}
