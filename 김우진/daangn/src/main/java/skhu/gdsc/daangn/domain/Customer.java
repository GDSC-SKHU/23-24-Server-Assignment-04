package skhu.gdsc.daangn.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "CUSTOMER_ADDRESS")
    private String customerAddress;

    public void updateName(String customerName) {
        if (customerName.isEmpty()) {
            return;
        }
        this.customerName = customerName;
    }
    public void updateAddress(String customerAddress) {
        if (customerAddress.isEmpty()) {
            return;
        }
        this.customerAddress = customerAddress;
    }



}
