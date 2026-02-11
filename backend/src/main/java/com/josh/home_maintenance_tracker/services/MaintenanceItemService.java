package com.josh.home_maintenance_tracker.services;

import com.josh.home_maintenance_tracker.exceptions.ResourceNotFoundException;
import com.josh.home_maintenance_tracker.models.MaintenanceItem;
import com.josh.home_maintenance_tracker.repositories.MaintenanceItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
7 operations:
getAllItems()
getItemById(Integer id)
createItem(MaintenanceItem item)
updateItem(Integer id, MaintenanceItem updatedItem)
deleteItem(Integer id)
getItemsByHomeId(Integer homeId)
getItemsByCategoryId(Integer categoryId)
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
        return maintenanceItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance item not found with id: " + id));
    }

    public MaintenanceItem createItem(MaintenanceItem maintenanceItem) {
        return maintenanceItemRepository.save(maintenanceItem);
    }

    public MaintenanceItem updateItem(Integer id, MaintenanceItem updatedItem) {
        // find the existingItem by ID
        MaintenanceItem existingItem = maintenanceItemRepository.findById(id)
                // throw custom exception if ID does not exist
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance item not found with id: " + id));
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

    public void deleteItem(Integer id) {
        MaintenanceItem existingMaintenanceItem = maintenanceItemRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Maintenance item not found with id: " + id));
        maintenanceItemRepository.delete(existingMaintenanceItem);
    }

    // custom filter methods (findByHomeId and findByCategoryId)

    public List<MaintenanceItem> getItemsByHomeId(Integer homeId) {
        return maintenanceItemRepository.findByHomeId(homeId);
    }

    public List<MaintenanceItem> getItemsByCategoryId(Integer categoryId) {
        return maintenanceItemRepository.findByCategoryId(categoryId);
    }
}
