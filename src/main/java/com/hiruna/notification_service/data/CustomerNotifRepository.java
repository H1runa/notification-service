package com.hiruna.notification_service.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerNotifRepository extends JpaRepository<CustomerNotif, Integer> {
    @Query("Select n from CustomerNotif n where n.customer_id = ?1")
    public List<CustomerNotif> getCustomerNotifsByCusId(int id);
}
