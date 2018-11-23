package com.study.cloud.order.domain;

import com.google.common.base.MoreObjects;

import java.time.LocalDateTime;

/**
 * 类描述：
 *
 * @author Weway-RG001
 * @date 2018-11-23 15:58
 */
public class Order {
    private String orderNo;
    private String customerName;
    private String sku;
    private int amount;
    private LocalDateTime ctime;

    public Order(String orderNo, String customerName, String sku, int amount) {
        this.orderNo = orderNo;
        this.customerName = customerName;
        this.sku = sku;
        this.amount = amount;
        ctime = LocalDateTime.now();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("orderNo", orderNo)
                .add("customerName", customerName)
                .add("sku", sku)
                .add("amount", amount)
                .add("ctime", ctime)
                .toString();
    }
}
