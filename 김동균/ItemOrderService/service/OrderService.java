package ItemOrderService.service;

import ItemOrderService.domain.Customer;
import ItemOrderService.domain.Item;
import ItemOrderService.domain.Order;
import ItemOrderService.repository.CustomerRepository;
import ItemOrderService.repository.ItemRepository;
import ItemOrderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


// 상품 구매 메소드
@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    // 상품 주문 메소드
    @Transactional
    public String itemOrderByCustomer(Integer customerId, Integer itemId, int quantity) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 ID입니다"));
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다"));

        if (item.getItemStock() >= quantity) {
           Order order = Order.builder()
                   .orderAmount(quantity)
                   .orderDate(String.valueOf(LocalDate.now()))
                   .customer(customer)
                   .item(item)
                   .build();
            orderRepository.save(order);
            itemStockUpdate(item.getItemId(), quantity);
            return "주문 완료";
        }
        return "재고가 부족합니다. 주문수량을 낮춰주세요.";
    }

    // 상품 재고 수정 메소드
    @Transactional
    public void itemStockUpdate(Integer itemId, int quantity){
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다"));
        item.updateItemStock(item.getItemStock() - quantity);
        itemRepository.save(item);
    }
}
