package com.hiruna.notification_service.service;

import com.hiruna.notification_service.data.CustomerNotif;
import com.hiruna.notification_service.data.CustomerNotifRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerNotifService {
    private CustomerNotifRepository repo;

    public CustomerNotifService(CustomerNotifRepository repo){
        this.repo=repo;
    }

    public void createNotif(CustomerNotif notif){
        repo.save(notif);
    }

    public List<CustomerNotif> getAllCustomerNotifs(){
        return repo.findAll();
    }

    public CustomerNotif getCustomerNotifById(int id){
        Optional<CustomerNotif> notif = repo.findById(id);
        if (notif.isPresent()){
            return notif.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<CustomerNotif> getCustomerNotifsByCusId(int id){
        return repo.getCustomerNotifsByCusId(id);
    }

    public CustomerNotif markAsRead(int id){
        Optional<CustomerNotif> notif = repo.findById(id);
        if (notif.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        CustomerNotif actual_notif = notif.get();
        actual_notif.setStatus("Read");
        return repo.save(actual_notif);
    }
}
