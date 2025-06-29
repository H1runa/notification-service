package com.hiruna.notification_service.controller;

import com.hiruna.notification_service.data.WorkerNotif;
import com.hiruna.notification_service.service.WorkerNotifService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker-notif")
public class WorkerNotifController {
    private WorkerNotifService workerNotifService;

    public WorkerNotifController(WorkerNotifService workerNotifService){
        this.workerNotifService=workerNotifService;
    }

    @GetMapping
    public ResponseEntity<List<WorkerNotif>> getAllWorkerNotifs(){
        return ResponseEntity.ok(workerNotifService.getAllWorkerNotifs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerNotif> getWorkerNotifById(@PathVariable int id){
        return ResponseEntity.ok(workerNotifService.getWorkerNotifById(id));
    }

    @GetMapping("/worker/{id}")
    public ResponseEntity<List<WorkerNotif>> getWorkerNotifsByWorkerId(@PathVariable int id){
        return ResponseEntity.ok(workerNotifService.getWorkerNotifsByWorkerId(id));
    }

    @PatchMapping("/{id}/mark-read")
    public ResponseEntity<WorkerNotif> markAsRead(@PathVariable int id){
        return ResponseEntity.ok(workerNotifService.markAsRead(id));
    }
}
