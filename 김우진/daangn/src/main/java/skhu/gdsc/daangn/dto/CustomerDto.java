package skhu.gdsc.daangn.dto;


import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private Long customerId;
    private String customerName;
    private String customerAddress;
}
