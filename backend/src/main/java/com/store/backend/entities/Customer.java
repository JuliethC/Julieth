package com.store.backend.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    
    @Id
    @Column(nullable = false, unique = true)
    private Long idCard;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private Gender gender;
    
    @Column(nullable = false)
    private LocalDate birthday;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private Payment payment;
    
    @Column(nullable = false)
    private Float points;
    
    @Column(nullable = false)
    private Boolean status;
    
    @Column(nullable = false)
    private String password;

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean checkPassword(String input) {
        return password.equals(input);
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
