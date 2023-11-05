package DTO;

import lombok.Getter;

@Getter
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

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
        this.phoneNumber = phoneNumber;
    }

}
