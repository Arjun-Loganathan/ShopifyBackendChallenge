package edu.dal.shopifybackendchallenge.inventory.repository;

import edu.dal.shopifybackendchallenge.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
