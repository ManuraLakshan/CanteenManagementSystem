package com.canteen.Fot.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class CanteenItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer item_id;

    private String item_name;
    private String item_category;
    private String supplier;
    private String unit;
    private Double unit_price;
    private Integer quantity;
    private Double total;

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || item_id == null) return null;
        return "/item-photos/" + item_id + "/" + photos;
    }

    @Column(nullable = true, length = 64)
    private String photos;

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }
}
