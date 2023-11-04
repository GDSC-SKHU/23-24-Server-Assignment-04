package skhu.gdsc.daangn.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import skhu.gdsc.daangn.domain.Customer;
import skhu.gdsc.daangn.domain.Orders;
import skhu.gdsc.daangn.domain.Products;
import skhu.gdsc.daangn.repository.CustomerRepository;
import skhu.gdsc.daangn.repository.OrderRepository;
import skhu.gdsc.daangn.repository.ProductsRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductsRepository productsRepository;

    @Transactional
    public String orderProducts(Long customerId, Long productId, Integer orderQuantity) { //상품 구매
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 고객 ID: " + customerId));
        Products products = productsRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 제품 ID: " + productId));

        Orders orders = Orders.builder()
                .customer(customer)
                .products(products)
                .orderQuantity(orderQuantity)
                .build();
        orderRepository.save(orders);
        return "주문 완료";
    }

}
