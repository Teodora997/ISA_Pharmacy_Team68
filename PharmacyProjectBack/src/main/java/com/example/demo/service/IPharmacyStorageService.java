package com.example.demo.service;


public interface IPharmacyStorageService {
    public Boolean checkAvailability(Long medId,Long phId);
    public void updateStorage(Long medId,Long phId);
}
