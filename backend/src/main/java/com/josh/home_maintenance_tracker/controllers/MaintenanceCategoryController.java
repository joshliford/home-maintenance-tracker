package com.josh.home_maintenance_tracker.controllers;

import com.josh.home_maintenance_tracker.models.MaintenanceCategory;
import com.josh.home_maintenance_tracker.services.MaintenanceCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories") // base URL path
public class MaintenanceCategoryController {

    private final MaintenanceCategoryService maintenanceCategoryService;

    public MaintenanceCategoryController(MaintenanceCategoryService maintenanceCategoryService) {
        this.maintenanceCategoryService = maintenanceCategoryService;
    }

    @GetMapping("")
    public List<MaintenanceCategory> getAllCategories() {
        return maintenanceCategoryService.getAllCategories();
    }

    // @PathVariable = extract ID from URL path variable
    @GetMapping("/{categoryId}")
    public MaintenanceCategory getCategoryById(@PathVariable int categoryId) {
        return maintenanceCategoryService.getCategoryById(categoryId);
    }

    // @RequestBody = accepts JSON payload in request body
    @PostMapping // standard REST convention to not use ("/add") for POST
    public MaintenanceCategory createCategory(@RequestBody MaintenanceCategory category) {
        return maintenanceCategoryService.createCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategoryById(@PathVariable int categoryId) {
        maintenanceCategoryService.deleteCategory(categoryId);
    }

}
