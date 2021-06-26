package com.canteen.Fot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer inv_id;
    private String name;
    private String discription;
    private Integer cat_id;
    private Integer unit_price;
    private Integer fixed_qunt;
    private Integer current_qunt;
    private String image;


    private String availability;

    public Integer getInv_id() {
        return inv_id;
    }

    public void setInv_id(Integer inv_id) {
        this.inv_id = inv_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public Integer getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Integer unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getFixed_qunt() {
        return fixed_qunt;
    }

    public void setFixed_qunt(Integer fixed_qunt) {
        this.fixed_qunt = fixed_qunt;
    }

    public Integer getCurrent_qunt() {
        return current_qunt;
    }

    public void setCurrent_qunt(Integer current_qunt) {
        this.current_qunt = current_qunt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
