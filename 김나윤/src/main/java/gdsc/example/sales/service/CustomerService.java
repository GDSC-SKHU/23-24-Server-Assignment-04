package gdsc.example.sales.service;

import gdsc.example.sales.domain.Customer;
import gdsc.example.sales.dto.CustomerDto;
import gdsc.example.sales.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    // Create
    @Transactional
    public String createCustomer(CustomerDto customerDto) {
        Customer customer = createCustomerData(customerDto);
        customerRepository.save(customer);
        return "저장완료";
    }

    private Customer
    createCustomerData(CustomerDto customerDto) {
        return Customer.builder()
                .name(customerDto.getName())
                .phNumber(customerDto.getPhNumber())
                        .build();
    }

    // Read
    public CustomerDto findCustomerByIdAsDto(Integer custoemrId) {
        return findCustomerById(custoemrId).toDto();
    }

    // Update
    @Transactional
    public String updateCustomer(CustomerDto customerDto) {
        Customer customer = findCustomerById(customerDto.getId());
        updateCustomer(customerDto, customer);
        customerRepository.save(customer);
        return "수정완료";
    }

    private void updateCustomer(CustomerDto customerDto, Customer customer) {
        customer.update(Customer.builder()
                .name(customerDto.getName())
                .phNumber(customerDto.getPhNumber())
                .build());
    }

    // Delete
    @Transactional
    public String deleteCustomer(Integer customerId) {
        Customer customer = findCustomerById(customerId);
        customerRepository.delete(customer);
        return "삭제완료";
    }

    private Customer findCustomerById(Integer customerId) {
        return customerRepository.findCustomerById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 고객 ID입니다"));
    }
}
