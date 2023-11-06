package skhu.gdsc.daangn.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Orders {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "ORDERS_ID")
    private Long orderId;

    @Column(name = "ORDERS_QUANTITY")
    private Integer orderQuantity;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @OneToOne
    private Products products;

}
