package edu.miu.cs590.orderservice.serviceimpl;

import edu.miu.cs590.orderservice.clients.PaymentFeignClient;
import edu.miu.cs590.orderservice.dto.OrderDto;
import edu.miu.cs590.orderservice.entity.*;

import edu.miu.cs590.orderservice.mapper.OrderMapper;
import edu.miu.cs590.orderservice.repository.OrderRepository;
import edu.miu.cs590.orderservice.service.OrderService;
import edu.miu.cs590.orderservice.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    PaymentFeignClient paymentServiceProxy;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderDto getById(Long id) {
        return MapperUtil.map(orderRepository.findById(id), OrderDto.class);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        try {
            List<Order> orders = orderRepository.findAll();
//            return orderMapper.toOrderDtos(orders);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public OrderDto save(OrderDto orderDto) {

        Order order = MapperUtil.map(orderDto, Order.class);
        order.setStatus(OrderStatus.DRAFT);

        //return null;
        return orderMapper.toOrderDto(orderRepository.save(order));
    }


    @Override
    public OrderDto pay(Long orderId, PaymentInfo paymentInfo) {
        Order order = orderRepository.getById(orderId);


        PaymentRequest request = new PaymentRequest();
        request.setUserId(order.getUserId());
        request.setOrderId(order.toString());
        request.setPaypalId(paymentInfo.getPaypalId());
        request.setBankAccNumber(paymentInfo.getBankAccNumber());
        request.setCreditCardNumber(paymentInfo.getCreditCardNumber());

        Double totalPrice = 0.0;

        for (Items item : order.getItems()) {
            totalPrice = item.getPrice();
        }

        request.setBalance(totalPrice);

        ResponseEntity<String> response = null;

        switch (order.getPaymentType()){
            case BANK:
                response = paymentServiceProxy.processBankPayment(request);
                break;
            case CC:
                response = paymentServiceProxy.processCcPayment(request);
                break;
            case PAYPAL:
                response = paymentServiceProxy.processPayPalPayment(request);
                break;

        }

        if (response.getStatusCode() != HttpStatus.OK) {
            return null;
        }

        order.setStatus(OrderStatus.PLACED);
        orderRepository.save(order);

        return MapperUtil.map(orderRepository.save(order), OrderDto.class);

    }

//    @Override
//    public ProductDto addProduct(ProductDto product) {
//        return  productMapper.toProductDto(productRepository.save(productMapper.dtoToEntity(product))) ;
//    }


    @Override
    public OrderDto updateStatus(Long id, OrderStatus status) {

        Order order = orderRepository.getReferenceById(id);
        order.setStatus(status);
        OrderDto orderDto = MapperUtil.map(orderRepository.save(order), OrderDto.class);
        return orderDto;

//        Order ord = orderMapper.dtoToOrder(orderDto);
//                if(ord != null){
//                    return orderMapper.toOrderDto(orderRepository.save(ord));
//                }
//                return null;
    }


    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

