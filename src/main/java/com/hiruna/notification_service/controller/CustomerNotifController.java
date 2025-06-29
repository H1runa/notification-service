package com.hiruna.notification_service.controller;

import com.hiruna.notification_service.data.CustomerNotif;
import com.hiruna.notification_service.service.CustomerNotifService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-notif")
public class CustomerNotifController {
    private CustomerNotifService customerNotifService;

    public CustomerNotifController(CustomerNotifService customerNotifService){
        this.customerNotifService=customerNotifService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerNotif>> getAllCusNotifs(){
        return ResponseEntity.ok(customerNotifService.getAllCustomerNotifs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerNotif> getCusNotifById(@PathVariable int id){
        return ResponseEntity.ok(customerNotifService.getCustomerNotifById(id));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<CustomerNotif>> getCusNotifsByCusId(@PathVariable int id){
        return ResponseEntity.ok(customerNotifService.getCustomerNotifsByCusId(id));
    }

    @PatchMapping("/{id}/mark-read")
    public ResponseEntity<CustomerNotif> markAsRead(@PathVariable int id){
        return ResponseEntity.ok(customerNotifService.markAsRead(id));
    }
}
