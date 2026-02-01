package com.josh.home_maintenance_tracker.services;

import com.josh.home_maintenance_tracker.models.MaintenanceCategory;
import com.josh.home_maintenance_tracker.repositories.MaintenanceCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public MaintenanceCategory getCategoryById(int id) {
        return maintenanceCategoryRepository.findById(id).orElse(null);
    }

    // creates a new category
    public MaintenanceCategory createCategory(MaintenanceCategory category) {
        return maintenanceCategoryRepository.save(category);
    }

    public void deleteCategory(int id) {
        maintenanceCategoryRepository.deleteById(id);
    }

}
