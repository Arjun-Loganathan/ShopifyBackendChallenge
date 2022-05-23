package edu.dal.shopifybackendchallenge.inventory.service;

import edu.dal.shopifybackendchallenge.inventory.model.Inventory;

import java.util.List;

public interface InventoryService
{
    Inventory addInventory(Inventory inventory);
    Inventory editInventory(Long id, Inventory inventory);
    List<Inventory> deleteInventory(Long id);
    List<Inventory> getAllInventory();
    Inventory getInventoryById(Long id);
}
