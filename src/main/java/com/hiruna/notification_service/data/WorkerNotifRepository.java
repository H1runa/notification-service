package com.hiruna.notification_service.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkerNotifRepository extends JpaRepository<WorkerNotif, Integer> {
    @Query("Select n from WorkerNotif n where n.worker_id = ?1")
    public List<WorkerNotif> getWorkerNotifsByWorkerId(int id);
}
