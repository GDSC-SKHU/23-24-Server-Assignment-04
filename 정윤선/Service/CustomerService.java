package Service;

import DTO.CustomerDTO;
import Domain.Customer;
import Repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());

        return customerRepository.save(customer);
    }

    public CustomerDTO getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));


        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhoneNumber(String.valueOf(customer.getPhoneNumber()));


        return customerDTO;
    }

    public Customer updateCustomer(Long customerId, CustomerDTO updatedCustomerDTO) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        customer.setName(updatedCustomerDTO.getName());
        customer.setEmail(updatedCustomerDTO.getEmail());
        customer.setPhoneNumber(updatedCustomerDTO.getPhoneNumber());

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId) {

        customerRepository.deleteById(customerId);
    }
}
