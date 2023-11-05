package gdsc.skhu.jpaexercise.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

// 상품에 대한 정보만 가지고있음.

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_price")
    private int price;

    @OneToMany(mappedBy = "item" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

}
