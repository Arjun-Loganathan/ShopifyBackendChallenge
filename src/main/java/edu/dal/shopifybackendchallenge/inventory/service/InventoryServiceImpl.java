package edu.dal.shopifybackendchallenge.inventory.service;

import edu.dal.shopifybackendchallenge.inventory.model.Inventory;
import edu.dal.shopifybackendchallenge.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory editInventory(Long id, Inventory inventory) {
        throwExceptionIfInventoryNotFound(id);
        Inventory existingInventory = inventoryRepository.findById(id).get();
        inventory.setId(existingInventory.getId());
        inventoryRepository.save(inventory);
        return inventory;
    }

    @Override
    public List<Inventory> deleteInventory(Long id) {
        throwExceptionIfInventoryNotFound(id);
        inventoryRepository.deleteById(id);
        return getAllInventory();
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory getInventoryById(Long id) {
        throwExceptionIfInventoryNotFound(id);
        return inventoryRepository.findById(id).get();
    }

    private void throwExceptionIfInventoryNotFound(Long id) {
       if(!inventoryRepository.existsById(id)) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no such product Not Found");
       }
    }
}