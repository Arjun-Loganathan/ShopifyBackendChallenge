package edu.dal.shopifybackendchallenge.inventory.controller;

import edu.dal.shopifybackendchallenge.inventory.model.Inventory;
import edu.dal.shopifybackendchallenge.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController
{
    @Autowired
    InventoryService inventoryService;

    @PostMapping("/add_inventory")
    public Inventory addInventory(@RequestBody Inventory inventory)
    {
        return inventoryService.addInventory(inventory);
    }

    @PostMapping("/edit_inventory/{id}")
    public Inventory editInventory(@PathVariable Long id, @RequestBody Inventory inventory)
    {
        return inventoryService.editInventory(id, inventory);
    }

    @PostMapping("/delete_inventory/{id}")
    public List<Inventory> deleteInventory(@PathVariable Long id)
    {
        return inventoryService.deleteInventory(id);
    }

    @GetMapping("/get_all_inventory")
    public List<Inventory> getAllInventory()
    {
        return inventoryService.getAllInventory();
    }
}
