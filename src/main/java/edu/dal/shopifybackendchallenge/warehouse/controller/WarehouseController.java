package edu.dal.shopifybackendchallenge.warehouse.controller;

import edu.dal.shopifybackendchallenge.warehouse.model.Warehouse;
import edu.dal.shopifybackendchallenge.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController
{
    @Autowired
    WarehouseService warehouseService;

    @PostMapping("/add_warehouse")
    public Warehouse addWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.addWarehouse(warehouse);
    }

    @PostMapping("/add_inventory/{warehouseId}")
    public Warehouse addProductToWarehouse(@PathVariable Long warehouseId, @RequestParam Long productId) {
        return warehouseService.addProductToWarehouse(warehouseId, productId);
    }

    @GetMapping("get_all_warehouse")
    public List<Warehouse> getAllWarehouse() {
        return warehouseService.getAllWarehouse();
    }
}
