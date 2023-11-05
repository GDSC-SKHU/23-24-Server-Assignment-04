package Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id
    private Long id;
    private Date orderDate;

    @ManyToOne
    private Customer customer;
    @ManyToMany
    private List<Item> items;

    public double calculateTotalPrice() {
        double totalPrice = 0.0;

        for (Item item : items) {
            totalPrice += item.getPrice();
        }

        return totalPrice;

    }

    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
