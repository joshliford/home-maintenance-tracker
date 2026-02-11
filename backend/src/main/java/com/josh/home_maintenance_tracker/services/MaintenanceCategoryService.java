package com.josh.home_maintenance_tracker.services;

import com.josh.home_maintenance_tracker.exceptions.ResourceNotFoundException;
import com.josh.home_maintenance_tracker.models.MaintenanceCategory;
import com.josh.home_maintenance_tracker.repositories.MaintenanceCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
4 operations:
getAllCategories()
getCategoryById(Integer id)
createCategory(MaintenanceCategory category)
deleteCategory(Integer id)
*/

@Service
public class MaintenanceCategoryService {

    // initialize repository
    private final MaintenanceCategoryRepository maintenanceCategoryRepository;

    // constructor injection
    public MaintenanceCategoryService(MaintenanceCategoryRepository maintenanceCategoryRepository) {
        this.maintenanceCategoryRepository = maintenanceCategoryRepository;
    }

    // business logic methods

    // return a list of all maintenance categories
    public List<MaintenanceCategory> getAllCategories() {
        return maintenanceCategoryRepository.findAll();
    }

    // return a category by id
    public MaintenanceCategory getCategoryById(Integer id) {
        return maintenanceCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance category not found with id: " + id));
    }

    // creates a new category
    public MaintenanceCategory createCategory(MaintenanceCategory category) {
        return maintenanceCategoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {
        MaintenanceCategory existingMaintenanceCategory = maintenanceCategoryRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Maintenance category not found with id: " + id));
        maintenanceCategoryRepository.delete(existingMaintenanceCategory);
    }

}
