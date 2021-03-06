package com.smartYummy.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglongwei
 * @version 1.0
 * @since 2016-05-09
 * <p/>
 * Shopping cart stored in httpsession and persist in Redis.
 */
public class ShoppingCart implements Serializable {
    private List<OrderItem> orderItems;

    public ShoppingCart() {
        orderItems = new LinkedList<OrderItem>();
    }

    public void addItem(OrderItem orderItem) {
        OrderItem foundItem = findOrderItemByItemId(orderItem.getItem().getId());
        if (foundItem == null) {
            orderItems.add(orderItem);
        } else {
            // found item, only increase quantity.
            foundItem.setQuantity(foundItem.getQuantity() + orderItem.getQuantity());
        }
    }

    public void removeItem(OrderItem orderItem) {
        OrderItem foundItem = findOrderItemByItemId(orderItem.getItem().getId());
        orderItems.remove(foundItem);
    }

    // only update order item quantity
    public void updateItem(OrderItem orderItem) {
        OrderItem foundItem = findOrderItemByItemId(orderItem.getItem().getId());
        if (foundItem != null) {
            foundItem.setQuantity(orderItem.getQuantity());
        }
    }

    public void clear() {
        orderItems.clear();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getQuantity() * orderItem.getItem().getPrice();
        }
        return totalPrice;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    private OrderItem findOrderItemByItemId(long itemID) {
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getItem().getId() == itemID) {
                return orderItem;
            }
        }
        return null;
    }
}
