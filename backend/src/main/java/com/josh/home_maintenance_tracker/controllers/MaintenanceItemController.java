package com.josh.home_maintenance_tracker.controllers;

import com.josh.home_maintenance_tracker.models.MaintenanceItem;
import com.josh.home_maintenance_tracker.services.MaintenanceItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public MaintenanceItem getItemById(@PathVariable int maintenanceItemId) {
        return maintenanceItemService.getItemById(maintenanceItemId);
    }

    @PostMapping
    public MaintenanceItem createMaintenanceItem(@RequestBody MaintenanceItem newMaintenanceItem) {
        return maintenanceItemService.createItem(newMaintenanceItem);
    }

    @PutMapping("/{maintenanceItemId}")
    public MaintenanceItem updateMaintenanceItem(@PathVariable int maintenanceItemId, @RequestBody MaintenanceItem maintenanceItem) {
        return maintenanceItemService.updateItem(maintenanceItemId, maintenanceItem);
    }

    @DeleteMapping("/{maintenanceItemId}")
    public void deleteItemById(@PathVariable int maintenanceItemId) {
        maintenanceItemService.deleteItemById(maintenanceItemId);
    }

    // custom requests

    @GetMapping("/home/{homeId}")
    public List<MaintenanceItem> getItemsByHomeId(@PathVariable int homeId) {
        return maintenanceItemService.getItemsByHomeId(homeId);
    }

    @GetMapping("/category/{categoryId}")
    public List<MaintenanceItem> getItemsByCategoryId(@PathVariable int categoryId) {
        return maintenanceItemService.getItemsByCategoryId(categoryId);
    }

}
