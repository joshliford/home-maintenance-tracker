package com.josh.home_maintenance_tracker.controllers;

import com.josh.home_maintenance_tracker.models.MaintenanceCategory;
import com.josh.home_maintenance_tracker.services.MaintenanceCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
4 endpoints:
GET api/categories (get all categories)
GET api/categories/{categoryId} (get category by ID)
POST api/categories (create new category)
DELETE api/categories/{categoryId} (delete category)
*/

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
    public MaintenanceCategory getCategoryById(@PathVariable Integer categoryId) {
        return maintenanceCategoryService.getCategoryById(categoryId);
    }

    // @RequestBody = accepts JSON payload in request body
    @PostMapping // standard REST convention to not use ("/add") for POST
    public MaintenanceCategory createCategory(@RequestBody MaintenanceCategory category) {
        return maintenanceCategoryService.createCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Integer categoryId) {
        maintenanceCategoryService.deleteCategory(categoryId);
    }

}
