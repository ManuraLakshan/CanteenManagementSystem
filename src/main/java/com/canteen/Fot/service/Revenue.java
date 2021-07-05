package com.canteen.Fot.service;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Revenue {

    @Id
    private String date;
    private float revenue;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }
}
