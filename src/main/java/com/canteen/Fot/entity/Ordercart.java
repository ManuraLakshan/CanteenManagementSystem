package com.canteen.Fot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ordercart {
    @Id
    private  int order_id;
    private String cust_id;
    private String discription;
    private  Integer unit_price;

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    private Integer item_id;
    public Integer getOrder_qunt() {
        return order_qunt;
    }

    public void setOrder_qunt(Integer order_qunt) {
        this.order_qunt = order_qunt;
    }

    private Integer order_qunt;
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Integer getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Integer unit_price) {
        this.unit_price = unit_price;
    }
}
