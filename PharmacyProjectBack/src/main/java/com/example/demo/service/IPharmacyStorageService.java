package com.example.demo.service;


import java.util.List;

public interface IPharmacyStorageService {
    public Boolean checkAvailability(Long medId,Long phId);
    public void updateStorage(Long medId,Long phId);
    public List<String> FindPharmacyMedicine(int pharmacyId);
}
