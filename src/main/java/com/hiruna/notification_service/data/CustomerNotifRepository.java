package com.hiruna.notification_service.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerNotifRepository extends JpaRepository<CustomerNotif, Integer> {
}
