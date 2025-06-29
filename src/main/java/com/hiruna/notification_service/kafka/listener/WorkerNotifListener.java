package com.hiruna.notification_service.kafka.listener;

import com.hiruna.notification_service.data.WorkerNotif;
import com.hiruna.notification_service.service.WorkerNotifService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class WorkerNotifListener {
    private WorkerNotifService workerNotifService;

    public WorkerNotifListener(WorkerNotifService workerNotifService){
        this.workerNotifService=workerNotifService;
    }

    @KafkaListener(topics = "worker-notification", groupId = "worker-notification-group1", containerFactory = "workerNotifListenerFactory")
    public void listener(WorkerNotif notif){
        workerNotifService.createNotif(notif);
    }
}
