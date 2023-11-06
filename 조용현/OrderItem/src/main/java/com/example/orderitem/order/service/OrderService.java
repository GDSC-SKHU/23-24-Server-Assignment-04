package com.example.orderitem.order.service;

import com.example.orderitem.domain.*;
import com.example.orderitem.item.repository.ItemRepository;
import com.example.orderitem.member.repository.MemberRepository;
import com.example.orderitem.order.dto.AddOrderRequest;
import com.example.orderitem.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /**
     * 주문
     */
    @Transactional
    public Order order(AddOrderRequest addOrderRequest){

        //엔티티 조회
        Member member = memberRepository.findById(addOrderRequest.memberId()).orElseThrow(() -> new IllegalArgumentException("찾으려는 회원이 없습니다."));
        Item item = itemRepository.findById(addOrderRequest.itemId()).orElseThrow(() -> new IllegalArgumentException("찾으려는 상품이 없습니다."));

        //배송정보 생성
        Delivery delivery = Delivery.builder().address(member.getAddress()).status(DeliveryStatus.READY).build();

        //주문 상품
        OrderItem orderItem = OrderItem.builder().item(item).orderPrice(item.getPrice()).count(addOrderRequest.count()).build();

        //주문 생성
        Order order = addOrderRequest.toEntity(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);

        return orderRepository.save(order);
    }

    /**
     * 주문 취소
     */
    @Transactional
    public void cancelOrder(Long orderId){
        //주문 엔티티 조회
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("찾으려는 주문이 없습니다."));
        //주문 취소
        order.cancel();
        orderRepository.delete(order);
    }

    //검색
    public Order findOrderById(Long orderId){
        return orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("찾으려는 주문이 없습니다."));
    }
}
