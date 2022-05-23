package edu.dal.shopifybackendchallenge.warehouse.service;

import edu.dal.shopifybackendchallenge.inventory.model.Inventory;
import edu.dal.shopifybackendchallenge.inventory.service.InventoryService;
import edu.dal.shopifybackendchallenge.warehouse.model.Warehouse;
import edu.dal.shopifybackendchallenge.warehouse.repository.WarehouseRepository;
import edu.dal.shopifybackendchallenge.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService
{
    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    InventoryService inventoryService;

    @Override
    public Warehouse addWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public Warehouse addProductToWarehouse(Long warehouseId, Long productId) {
        throwExceptionIfWarehouseNotFound(warehouseId);

        Warehouse warehouse = warehouseRepository.findById(warehouseId).get();
        Inventory inventory = inventoryService.getInventoryById(productId);
        List<Inventory> warehouseList = warehouse.getInventoryList();

        if(warehouseList==null) {
            warehouseList=new ArrayList<Inventory>();
        }

        warehouseList.add(inventory);
        warehouse.setInventoryList(warehouseList);
        return warehouseRepository.save(warehouse);
    }

    @Override
    public List<Warehouse> getAllWarehouse() {
        return warehouseRepository.findAll();
    }

    private void throwExceptionIfWarehouseNotFound(Long id) {
        if(!warehouseRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no warehouse Found");
        }
    }
}
