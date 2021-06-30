package com.canteen.Fot.entity;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sup_id;
    private String sup_name;
    private String sup_address;
    private String sup_email;
    private String sup_phone;

    public Integer getSup_id() {
        return sup_id;
    }

    public void setSup_id(Integer sup_id) {
        this.sup_id = sup_id;
    }

    public String getSup_name() {
        return sup_name;
    }

    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }

    public String getSup_address() {
        return sup_address;
    }

    public void setSup_address(String sup_address) {
        this.sup_address = sup_address;
    }

    public String getSup_email() {
        return sup_email;
    }

    public void setSup_email(String sup_email) {
        this.sup_email = sup_email;
    }

    public String getSup_phone() {
        return sup_phone;
    }

    public void setSup_phone(String sup_phone) {
        this.sup_phone = sup_phone;
    }
}
