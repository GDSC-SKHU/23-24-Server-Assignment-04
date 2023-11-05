package DTO;

import lombok.Getter;

@Getter
public class ItemDTO {
    private Long id;
    private String name;
    private double price;

    public ItemDTO() {
        this.price = price;
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
