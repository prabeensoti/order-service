package edu.miu.cs590.orderservice.mapper;

import edu.miu.cs590.orderservice.dto.OrderDto;
import edu.miu.cs590.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.Optional;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = {ItemsMapper.class})
public interface OrderMapper {

        OrderDto toOrderDto(Order order);

        Order dtoToOrder(OrderDto OrderDto);
}