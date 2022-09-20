package edu.miu.cs590.orderservice.service;

import edu.miu.cs590.orderservice.dto.ItemsDto;
import edu.miu.cs590.orderservice.entity.Items;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemsService {

    ItemsDto getItemById(Long Id);
    List<Items> saveAll(List<Items> items);
}
