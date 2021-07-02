package com.canteen.Fot;

import groovy.transform.ToString;


import javax.persistence.*;
import java.util.List;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer order_id;
    private Integer item_id;
    private String cust_id;
    private Integer order_qunt;
    private float total;
    private  Integer purchased_states;


    public Integer getPurchased_states() {
        return purchased_states;
    }

    public void setPurchased_states(Integer purchased_states) {
        this.purchased_states = purchased_states;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public Integer getOrder_qunt() {
        return order_qunt;
    }

    public void setOrder_qunt(Integer order_qunt) {
        this.order_qunt = order_qunt;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }


}
