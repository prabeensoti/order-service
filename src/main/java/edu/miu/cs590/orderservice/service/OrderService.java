package edu.miu.cs590.orderservice.service;

import edu.miu.cs590.orderservice.dto.OrderDto;
import edu.miu.cs590.orderservice.entity.OrderStatus;
import edu.miu.cs590.orderservice.entity.PaymentInfo;

import java.util.List;


public interface OrderService {
    OrderDto getById(Long id);
    List<OrderDto> getAllOrders();
    OrderDto save(OrderDto order);
    OrderDto updateStatus(Long orderId, OrderStatus status);


    OrderDto pay(Long orderId, PaymentInfo paymentInfo);
     void deleteOrder(Long id);

}
