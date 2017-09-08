package com.myorg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class House {

    @Id
    @Column(name="building_id")
    private int id;

    @Column(name="building_name")
    private String name;

    @Column(name="building_price")
    private int price;

    @Column(name="building_status")
    private String status;

    @Column(name="building_address")
    private String address;

    public House() {
    }

    public House(int id, String name, int price, String status, String address) {
        this.id = id;

        this.name = name;
        this.price = price;
        this.status = status;
        this.address = address;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
