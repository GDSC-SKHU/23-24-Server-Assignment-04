package Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Customer {
    @Getter
    @Id
    private Long id;

    @Getter
    private String name;

    @Getter
    private String email;
    @Getter
    private Double phoneNumber;
    private Order[] orders;

    public double calculateTotalOrdersAmount() {
        double totalAmount = 0.0;

        for (Order order : orders) {
            totalAmount += order.calculateTotalPrice();
        }

        return totalAmount;
    }

    public void updateContactInformation(String email, String phoneNumber) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }

        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            this.phoneNumber = Double.valueOf(phoneNumber);
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = Double.valueOf(phoneNumber);
    }

}
