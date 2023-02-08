/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.d3r3k.tutorias;

/**
 *
 * @author D3r3k
 */
public class Carros {
    private String model;
    private Double price;
    private int age;

    public Carros(String model, Double price, int age) {
        this.model = model;
        this.price = price;
        this.age = age;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
