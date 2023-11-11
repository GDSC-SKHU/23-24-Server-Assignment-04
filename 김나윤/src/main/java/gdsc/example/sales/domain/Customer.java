package gdsc.example.sales.domain;

import gdsc.example.sales.dto.CustomerDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "Cu_Id")
    private Integer id;

    @Column(name = "Cu_Name", nullable = false)
    private String name;

    @Column(name = "Ph_Number", nullable = false)
    private String phNumber;

    public CustomerDto toDto() {
        return CustomerDto.builder()
                .id(this.id)
                .name(this.name)
                .phNumber(this.phNumber)
                .build();
    }

    public void update(Customer customer) {
        this.name = customer.name;
        this.phNumber = customer.phNumber;
    }
}
