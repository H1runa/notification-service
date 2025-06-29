package com.hiruna.notification_service.service;

import com.hiruna.notification_service.data.WorkerNotif;
import com.hiruna.notification_service.data.WorkerNotifRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerNotifService {
    private WorkerNotifRepository workerNotifRepository;

    public WorkerNotifService(WorkerNotifRepository workerNotifRepository){
        this.workerNotifRepository=workerNotifRepository;
    }

    public void createNotif(WorkerNotif notif){
        workerNotifRepository.save(notif);
    }

    public List<WorkerNotif> getAllWorkerNotifs(){
       return workerNotifRepository.findAll();
    }

    public List<WorkerNotif> getWorkerNotifsByWorkerId(int id){
        return workerNotifRepository.getWorkerNotifsByWorkerId(id);
    }

    public WorkerNotif getWorkerNotifById(int id){
        Optional<WorkerNotif> notif = workerNotifRepository.findById(id);
        if (notif.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return notif.get();
        }
    }

    public WorkerNotif markAsRead(int id){
        Optional<WorkerNotif> notif = workerNotifRepository.findById(id);
        if (notif.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            WorkerNotif actual_notif = notif.get();
            actual_notif.setStatus("Read");
            return workerNotifRepository.save(actual_notif);
        }
    }
}
