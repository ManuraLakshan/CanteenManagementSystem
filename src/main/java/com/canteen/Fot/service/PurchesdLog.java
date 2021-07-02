package com.canteen.Fot.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PurchesdLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    private int oderid;
    private String custid;
    private Integer qunty;
    private float total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOderid() {
        return oderid;
    }

    public void setOderid(int oderid) {
        this.oderid = oderid;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public Integer getQunty() {
        return qunty;
    }

    public void setQunty(Integer qunty) {
        this.qunty = qunty;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
