package com.josh.home_maintenance_tracker.controllers;

import com.josh.home_maintenance_tracker.models.MaintenanceRecord;
import com.josh.home_maintenance_tracker.services.MaintenanceRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
5 endpoints:
GET /api/maintenance-records (get all records)
GET /api/maintenance-records/{maintenanceRecordId} (get record by ID)
POST /api/maintenance-records (create new record)
PUT /api/maintenance-records/{maintenanceRecordId} (update existing record)
DELETE /api/maintenace-records/{maintenanceRecordId} (delete record by)
*/

@RestController
@RequestMapping("/api/maintenance-records")
public class MaintenanceRecordController {

    private final MaintenanceRecordService maintenanceRecordService;

    public MaintenanceRecordController(MaintenanceRecordService maintenanceRecordService) {
        this.maintenanceRecordService = maintenanceRecordService;
    }

    @GetMapping("")
    public List<MaintenanceRecord> getAllMaintenanceRecords() {
        return maintenanceRecordService.getAllMaintenanceRecords();
    }

    @GetMapping("/{maintenanceRecordId}")
    public MaintenanceRecord getMaintenanceRecordById(@PathVariable Integer maintenanceRecordId) {
        return maintenanceRecordService.getMaintenanceRecordById(maintenanceRecordId);
    }

    @PostMapping
    public MaintenanceRecord createMaintenanceRecord(@RequestBody MaintenanceRecord maintenanceRecord) {
        return maintenanceRecordService.createMaintenanceRecord(maintenanceRecord);
    }

    @PutMapping("/{maintenanceRecordId}")
    public MaintenanceRecord updateMaintenanceRecord(@PathVariable Integer maintenanceRecordId, @RequestBody MaintenanceRecord maintenanceRecord) {
        return maintenanceRecordService.updateMaintenanceRecord(maintenanceRecordId, maintenanceRecord);
    }

    @DeleteMapping("/{maintenanceRecordId}")
    public void deleteMaintenanceRecord(@PathVariable Integer maintenanceRecordId) {
        maintenanceRecordService.deleteMaintenanceRecord(maintenanceRecordId);
    }

    // custom endpoint
    @GetMapping("/maintenance-item/{maintenanceItemId}")
    public List<MaintenanceRecord> getRecordByMaintenanceItemId(@PathVariable Integer maintenanceItemId) {
        return maintenanceRecordService.getByMaintenanceItemId(maintenanceItemId);
    }

}
