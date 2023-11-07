package Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Item {
    @Id
    private Long id;

    private String name;


    private double price;

    public void updatePrice(double newPrice) {
        if (newPrice >= 0) { // 가격은 음수가 될 수 없음
            this.price = newPrice;
        } else {
            throw new IllegalArgumentException("가격은 음수일 수 없습니다.");
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
