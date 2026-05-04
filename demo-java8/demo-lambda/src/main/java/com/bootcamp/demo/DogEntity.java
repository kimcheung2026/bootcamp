package com.bootcamp.demo;

// Entity: 對應資料庫
class DogEntity {
  private Long id;
  private String name;
  private int age;

  // Constructor, Getters...
  public DogEntity(Long id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}

// DTO: 傳給前端，通常會過濾掉敏感資訊或簡化欄位
class DogDTO {
  private String dogName;
  private String category; // 根據年齡判斷是小狗還是老狗

  public DogDTO(String name, String category) {
    this.dogName = name;
    this.category = category;
  }

  @Override
  public String toString() {
    return "DogDTO{name='" + dogName + "', cat='" + category + "'}";
  }
}
