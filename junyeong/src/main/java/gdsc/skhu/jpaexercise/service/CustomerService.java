package gdsc.skhu.jpaexercise.service;

import gdsc.skhu.jpaexercise.domain.Customer;
import gdsc.skhu.jpaexercise.dto.CustomerDto;
import gdsc.skhu.jpaexercise.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional
    public String createCustomer(CustomerDto customerDto) {
        Customer customer =  Customer.builder()
                .name(customerDto.getName())
                .age(customerDto.getAge())
                .build();
        customerRepository.save(customer);
        return "저장됨";
    }


    public Customer findCustomerByName(String name) {
        return customerRepository.findByName(name).orElseThrow(()
                -> new IllegalArgumentException("해당 고객이름이 없습니다."));

    }
    public Customer findCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 고객ID가 없습니다."));
    }
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    @Transactional
    public String updateCustomer(CustomerDto customerDto){
        Customer customer = customerRepository.findById(customerDto.getId()).orElseThrow(()
                -> new IllegalArgumentException("해당 고객ID가 없습니다."));
        customer.updateName(customerDto.getName());
        customer.updateAge(customerDto.getAge());
        return "수정됨";
    }

    @Transactional
    public String deleteCustomer(Integer id){
        Customer customer = customerRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 고객ID가 없습니다."));
        customerRepository.delete(customer);
        return "삭제됨";
    }
}
