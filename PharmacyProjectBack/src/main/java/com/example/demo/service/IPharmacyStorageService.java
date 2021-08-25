package com.example.demo.service;


public interface IPharmacyStorageService {
    public Boolean checkAvailability(Long medId,Long phId);
    public void updateStorage(Long medId,Long phId);
    public Boolean checkAmount(Long medId,Long phId,int amount);
    public void updateAfterCancel(Long medId,Long phId);
}
