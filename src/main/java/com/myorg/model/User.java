package com.myorg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "realname")
    private String realname;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private int status;

    @Column(name = "role_id")
    private int role_id;

    @Column(name = "register_time")
    private Date register_time;

    @Column(name = "register_ip")
    private String register_ip;

    @Column(name = "last_login_time")
    private Date last_login_time;

    @Column(name = "last_login_ip")
    private String last_login_ip;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }

    public String getRegister_ip() {
        return register_ip;
    }

    public void setRegister_ip(String register_ip) {
        this.register_ip = register_ip;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getLast_login_ip() {
        return last_login_ip;
    }

    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip;
    }

    public User() {
    }

    public User(int id, String name, String password, String realname, String address, int status, int role_id, Date register_time, String register_ip, Date last_login_time, String last_login_ip) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.realname = realname;
        this.address = address;
        this.status = status;
        this.role_id = role_id;
        this.register_time = register_time;
        this.register_ip = register_ip;
        this.last_login_time = last_login_time;
        this.last_login_ip = last_login_ip;
    }
}
