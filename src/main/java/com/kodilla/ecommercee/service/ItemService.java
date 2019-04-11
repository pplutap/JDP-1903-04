package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.Exception.ItemNotFoundException;
import com.kodilla.ecommercee.domain.orders.Item;
import com.kodilla.ecommercee.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item findItemById(Long itemId) throws ItemNotFoundException{
        return itemRepository.findById(itemId).orElseThrow(ItemNotFoundException::new);
    }

    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

}
