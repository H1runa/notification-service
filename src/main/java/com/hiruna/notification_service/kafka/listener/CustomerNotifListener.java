package com.hiruna.notification_service.kafka.listener;

import com.hiruna.notification_service.data.CustomerNotif;
import com.hiruna.notification_service.service.CustomerNotifService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class CustomerNotifListener {
    private CustomerNotifService customerNotifService;

    public CustomerNotifListener(CustomerNotifService customerNotifService){
        this.customerNotifService=customerNotifService;
    }

    @KafkaListener(topics = "customer-notification", groupId = "customer-notification-group1", containerFactory = "customerNotifListenerFactory")
    public void listener(CustomerNotif notif){
        customerNotifService.createNotif(notif);
    }
}
