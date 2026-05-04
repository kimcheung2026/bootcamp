package com.bootcamp.demo;

import java.util.Arrays;
import java.util.List;

class DogDAO {
  // 模擬資料庫撈取資料
  public List<DogEntity> findAllDogs() {
    return Arrays.asList(
        new DogEntity(1L, "Buddy", 2),
        new DogEntity(2L, "Max", 8),
        new DogEntity(3L, "Lucy", 12));
  }
}