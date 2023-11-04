package skhu.gdsc.daangn.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class ProductDto {
    private Long productId;
    private String productName;
    private Integer productPrice;
}
