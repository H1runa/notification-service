package com.hiruna.notification_service.service;

import com.hiruna.notification_service.data.WorkerNotif;
import com.hiruna.notification_service.data.WorkerNotifRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkerNotifService {
    private WorkerNotifRepository workerNotifRepository;

    public WorkerNotifService(WorkerNotifRepository workerNotifRepository){
        this.workerNotifRepository=workerNotifRepository;
    }

    public void createNotif(WorkerNotif notif){
        workerNotifRepository.save(notif);
    }
}
