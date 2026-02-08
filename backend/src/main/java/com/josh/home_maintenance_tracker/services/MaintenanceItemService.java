package com.josh.home_maintenance_tracker.services;

import com.josh.home_maintenance_tracker.models.MaintenanceItem;
import com.josh.home_maintenance_tracker.repositories.MaintenanceItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
7 operations:
getAllItems()
getItemById(int id)
createItem(MaintenanceItem item)
updateItem(int id, MaintenanceItem item)
deleteItem(int id)
getItemsByHomeId(int homeId)
getItemsByCategoryId(int categoryId)
*/

@Service
public class MaintenanceItemService {

    private final MaintenanceItemRepository maintenanceItemRepository;

    public MaintenanceItemService(MaintenanceItemRepository maintenanceItemRepository) {
        this.maintenanceItemRepository = maintenanceItemRepository;
    }

    public List<MaintenanceItem> getAllItems() {
        return maintenanceItemRepository.findAll();
    }

    public MaintenanceItem getItemById(Integer id) {
        return maintenanceItemRepository.findById(id).orElse(null);
    }

    public MaintenanceItem createItem(MaintenanceItem maintenanceItem) {
        return maintenanceItemRepository.save(maintenanceItem);
    }

    public MaintenanceItem updateItem(Integer id, MaintenanceItem updatedItem) {
        // find the existingItem by ID
        MaintenanceItem existingItem = maintenanceItemRepository.findById(id).orElse(null);
        if (existingItem == null) {
            return null; // TODO: throw exception
        }
        // update all fields with updatedItem info (exclude id and createdAt)
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setYearInstalled(updatedItem.getYearInstalled());
        existingItem.setHome(updatedItem.getHome());
        existingItem.setCategory(updatedItem.getCategory());
        existingItem.setModel(updatedItem.getModel());
        existingItem.setSerialNumber(updatedItem.getSerialNumber());
        existingItem.setMaintenanceFrequencyDays(updatedItem.getMaintenanceFrequencyDays());
        existingItem.setNotes(updatedItem.getNotes());
        existingItem.setUpdatedAt(LocalDateTime.now());
        // returns the saved entity (item from database), not updatedItem (client side data)
        return maintenanceItemRepository.save(existingItem);
    }

    public void deleteItemById(Integer id) {
        maintenanceItemRepository.deleteById(id);
    }

    // custom filter methods (findByHomeId and findByCategoryId)

    public List<MaintenanceItem> getItemsByHomeId(Integer homeId) {
        return maintenanceItemRepository.findByHomeId(homeId);
    }

    public List<MaintenanceItem> getItemsByCategoryId(Integer categoryId) {
        return maintenanceItemRepository.findByCategoryId(categoryId);
    }
}
