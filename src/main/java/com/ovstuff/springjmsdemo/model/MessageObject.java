package com.ovstuff.springjmsdemo.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by ovaldez on 10/25/15.
 */
public class MessageObject implements Serializable {

    private String uuid;
    private Calendar timeStamp;
    private Long quantity;
    private Double price;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Calendar getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Calendar timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
