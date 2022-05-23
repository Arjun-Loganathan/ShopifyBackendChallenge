package edu.dal.shopifybackendchallenge.warehouse.repository;

import edu.dal.shopifybackendchallenge.warehouse.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
