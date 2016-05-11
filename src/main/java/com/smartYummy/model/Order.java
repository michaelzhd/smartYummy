package com.smartYummy.model;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * Created by chenglongwei on 5/8/16.
 */
@Entity
@Table(name = "yummy_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Temporal(TemporalType.TIMESTAMP)
    private Date pickup_time;

    @Temporal(TemporalType.TIMESTAMP)
    private Date start_time;

    // unit minutes
    private int prepare_time;

    /**
     * including: not started; started; finished
     */
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Date getPickup_time() {
        return pickup_time;
    }

    public void setPickup_time(Date pickup_time) {
        this.pickup_time = pickup_time;
    }

    public int getPrepare_time() {
        return prepare_time;
    }

    public void setPrepare_time(int prepare_time) {
        this.prepare_time = prepare_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }
}
