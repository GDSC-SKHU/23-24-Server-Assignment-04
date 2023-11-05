package DTO;

import Domain.Customer;
import Domain.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDTO {
    @Getter
    private Long id;
    private Long customerId;
    private List<Long> itemIds;
    @Getter
    private Date orderDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return new Customer();
    }

    public void setCustomer(Customer customer) {
    }

    public List<Item> getItems() {
        return new ArrayList<>();
    }

    public void setItems(List<Item> items) {
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
