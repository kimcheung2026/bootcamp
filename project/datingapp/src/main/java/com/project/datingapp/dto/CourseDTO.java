package com.project.datingapp.dto;

import java.math.BigDecimal;

public class CourseDTO {
  private String title;
  private String description;
  private BigDecimal price;

  // getter
  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  // setter
  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

}