package com.example.floristeriaiudigital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flower")
public class FloresModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private long id;

  @Column(length = 100)
  private String type;

  @Column(length = 50)
  private String color;

  @Column(length = 50)
  private String variety;

  @Column(nullable = false)
  private int quantity;

  @Column(nullable = false)
  private double purchasePrice;

  @Column(nullable = false)
  private double sellingPrice;

  // Getters y Setters
  public long getIdFlor() {
    return id;
  }
  public void setIdFlor(long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public String getColor() {
    return color;
  }
  public void setColor(String color) {
    this.color = color;
  }

  public String getVariety() {
    return variety;
  }
  public void setVariety(String variety) {
    this.variety = variety;
  }

  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPurchasePrice() {
    return purchasePrice;
  }
  public void setPurchasePrice(double purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  public double getSellingPrice() {
    return sellingPrice;
  }
  public void setSellingPrice(double sellingPrice) {
    this.sellingPrice = sellingPrice;
  }
}
