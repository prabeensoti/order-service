package edu.miu.cs590.orderservice.mapper;

import edu.miu.cs590.orderservice.dto.ShippingAddressDto;
import edu.miu.cs590.orderservice.entity.ShippingAddress;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ShippingAddressMapper {

    ShippingAddress toEntity(ShippingAddressDto shippingAddressDto);

    ShippingAddressDto toDto(ShippingAddress shippingAddress);

}
