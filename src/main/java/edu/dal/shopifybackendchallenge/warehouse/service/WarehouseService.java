package edu.dal.shopifybackendchallenge.warehouse.service;

import edu.dal.shopifybackendchallenge.warehouse.model.Warehouse;

import java.util.List;

public interface WarehouseService {
    Warehouse addWarehouse(Warehouse warehouse);
    Warehouse addProductToWarehouse(Long warehouseId, Long productId);
    List<Warehouse> getAllWarehouse();
}
