package com.josh.home_maintenance_tracker.services;

import com.josh.home_maintenance_tracker.models.MaintenanceRecord;
import com.josh.home_maintenance_tracker.repositories.MaintenanceRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
5 operations + 1 custom filter method:
getAllMaintenanceRecords
getMaintenanceRecordById
createMaintenanceRecord
updateMaintenanceRecord
deleteMaintenanceRecordById
getByMaintenanceItemId
*/

@Service
public class MaintenanceRecordService {

    private final MaintenanceRecordRepository maintenanceRecordRepository;

    public MaintenanceRecordService(MaintenanceRecordRepository maintenanceRecordRepository) {
        this.maintenanceRecordRepository = maintenanceRecordRepository;
    }

    public List<MaintenanceRecord> getAllMaintenanceRecords() {
        return maintenanceRecordRepository.findAll();
    }

    public MaintenanceRecord getMaintenanceRecordById(Integer id) {
        return maintenanceRecordRepository.findById(id).orElse(null);
    }

    public MaintenanceRecord createMaintenanceRecord(MaintenanceRecord newMaintenanceRecord) {
        newMaintenanceRecord.setCreatedAt(LocalDateTime.now());
        return maintenanceRecordRepository.save(newMaintenanceRecord);
    }

    public MaintenanceRecord updateMaintenanceRecord(Integer id, MaintenanceRecord updatedMaintenanceRecord) {
        MaintenanceRecord existingMaintenanceRecord = maintenanceRecordRepository.findById(id).orElse(null);
        if (existingMaintenanceRecord == null) {
            return null; // TODO: throw exception
        }
        existingMaintenanceRecord.setCost(updatedMaintenanceRecord.getCost());
        existingMaintenanceRecord.setNotes(updatedMaintenanceRecord.getNotes());
        existingMaintenanceRecord.setCompletedAt(updatedMaintenanceRecord.getCompletedAt());
        existingMaintenanceRecord.setCompletedBy(updatedMaintenanceRecord.getCompletedBy());
        existingMaintenanceRecord.setUpdatedAt(LocalDateTime.now());
        return maintenanceRecordRepository.save(existingMaintenanceRecord);
    }

    public void deleteMaintenanceRecord(Integer id) {
        maintenanceRecordRepository.deleteById(id);
    }

    // custom filter method
    public List<MaintenanceRecord> getByMaintenanceItemId(Integer maintenanceItemId) {
        return maintenanceRecordRepository.findByMaintenanceItemId(maintenanceItemId);
    }

}
