package com.hiruna.notification_service.data;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "customer_notif")
public class CustomerNotif {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "worker_id")
    private int worker_id;

    @Column(name = "customer_contract_id")
    private int customer_contract_id;

    @Column(name = "worker_contract_id")
    private int worker_contract_id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @Column(name = "status")
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public int getCustomer_contract_id() {
        return customer_contract_id;
    }

    public void setCustomer_contract_id(int customer_contract_id) {
        this.customer_contract_id = customer_contract_id;
    }

    public int getWorker_contract_id() {
        return worker_contract_id;
    }

    public void setWorker_contract_id(int worker_contract_id) {
        this.worker_contract_id = worker_contract_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
