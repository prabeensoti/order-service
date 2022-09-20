package edu.miu.cs590.orderservice.controller;


import edu.miu.cs590.orderservice.dto.OrderDto;
import edu.miu.cs590.orderservice.entity.OrderStatus;
import edu.miu.cs590.orderservice.entity.PaymentInfo;
import edu.miu.cs590.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping()
    public ResponseEntity<List<OrderDto>> getAllOrders() {

        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")

    public ResponseEntity<OrderDto> getById(@PathVariable Long id) {

        return new ResponseEntity<>(orderService.getById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> saveOrder(@RequestBody OrderDto orderDto) {
        OrderDto orderDto1 = orderService.save(orderDto);
        if (orderDto1 == null) return new ResponseEntity<>("Order create failed", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(orderDto1, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody OrderStatus orderStatus) {
        return new ResponseEntity<Object>(orderService.updateStatus(id,orderStatus), HttpStatus.OK);
    }

    @PostMapping("/{id}/pay")
    public ResponseEntity<?> pay(@PathVariable Long id, @RequestBody PaymentInfo paymentInfo){
        OrderDto orderDto = orderService.pay(id, paymentInfo);
        if(orderDto == null) return new ResponseEntity<>("Payment failed", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }



    @DeleteMapping("/{id}")

    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
