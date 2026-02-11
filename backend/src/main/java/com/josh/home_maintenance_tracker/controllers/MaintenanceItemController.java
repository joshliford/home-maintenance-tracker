package com.josh.home_maintenance_tracker.controllers;

import com.josh.home_maintenance_tracker.models.MaintenanceItem;
import com.josh.home_maintenance_tracker.services.MaintenanceItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
5 endpoints + 2 custom endpoints:
GET /api/maintenance-items (get all maintenance items)
GET /api/maintenance-items/{maintenanceItemId} (get maintenance item by ID)
POST /api/maintenance-items (create new maintenance item)
PUT /api/maintenance-items/{maintenanceItemId} (update existing maintenance item)
DELETE /api/maintenance-items/{maintenanceItemId} (delete maintenance item)
GET /api/maintenance-items/home/{homeId} (get maintenance items by home ID)
GET /api/maintenance-items/category/{categoryId} (get maintenance items by category ID)
*/

@RestController
@RequestMapping("/api/maintenance-items")
public class MaintenanceItemController {

    private final MaintenanceItemService maintenanceItemService;

    public MaintenanceItemController(MaintenanceItemService maintenanceItemService) {
        this.maintenanceItemService = maintenanceItemService;
    }

    @GetMapping("")
    public List<MaintenanceItem> getAllItems() {
        return maintenanceItemService.getAllItems();
    }

    @GetMapping("/{maintenanceItemId}")
    public MaintenanceItem getItemById(@PathVariable Integer maintenanceItemId) {
        return maintenanceItemService.getItemById(maintenanceItemId);
    }

    @PostMapping
    public MaintenanceItem createMaintenanceItem(@RequestBody MaintenanceItem newMaintenanceItem) {
        return maintenanceItemService.createItem(newMaintenanceItem);
    }

    @PutMapping("/{maintenanceItemId}")
    public MaintenanceItem updateMaintenanceItem(@PathVariable Integer maintenanceItemId, @RequestBody MaintenanceItem maintenanceItem) {
        return maintenanceItemService.updateItem(maintenanceItemId, maintenanceItem);
    }

    @DeleteMapping("/{maintenanceItemId}")
    public void deleteItem(@PathVariable Integer maintenanceItemId) {
        maintenanceItemService.deleteItem(maintenanceItemId);
    }

    // custom endpoints

    @GetMapping("/home/{homeId}")
    public List<MaintenanceItem> getItemsByHomeId(@PathVariable Integer homeId) {
        return maintenanceItemService.getItemsByHomeId(homeId);
    }

    @GetMapping("/category/{categoryId}")
    public List<MaintenanceItem> getItemsByCategoryId(@PathVariable int categoryId) {
        return maintenanceItemService.getItemsByCategoryId(categoryId);
    }

}
