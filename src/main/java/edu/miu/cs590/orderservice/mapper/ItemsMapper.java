package edu.miu.cs590.orderservice.mapper;


import edu.miu.cs590.orderservice.dto.ItemsDto;
import edu.miu.cs590.orderservice.entity.Items;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ItemsMapper {

    Items toEntity(ItemsDto itemsDto);
    ItemsDto toDto(Items items);
}
