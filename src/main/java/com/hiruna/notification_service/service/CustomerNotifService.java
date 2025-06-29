package com.hiruna.notification_service.service;

import com.hiruna.notification_service.data.CustomerNotif;
import com.hiruna.notification_service.data.CustomerNotifRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerNotifService {
    private CustomerNotifRepository repo;

    public CustomerNotifService(CustomerNotifRepository repo){
        this.repo=repo;
    }

    public void createNotif(CustomerNotif notif){
        repo.save(notif);
    }
}
