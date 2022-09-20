package edu.miu.cs590.orderservice.serviceimpl;
import edu.miu.cs590.orderservice.dto.ItemsDto;
import edu.miu.cs590.orderservice.entity.Items;
import edu.miu.cs590.orderservice.repository.ItemsRepository;
import edu.miu.cs590.orderservice.service.ItemsService;
import edu.miu.cs590.orderservice.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

//    @Autowired
//    ItemsMapper itemsMapper;

    @Autowired
    ItemsRepository itemsRepository;

    @Override
    public ItemsDto getItemById(Long id) {
        return MapperUtil.map(itemsRepository.getById(id), ItemsDto.class);
    }

    @Override
    public List<Items> saveAll(List<Items> items) {
        return itemsRepository.saveAll(items);
    }


}
