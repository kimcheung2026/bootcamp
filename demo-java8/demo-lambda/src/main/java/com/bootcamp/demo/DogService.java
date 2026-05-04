package com.bootcamp.demo;

import java.util.List;
import java.util.stream.Collectors;

class DogService {
  private DogDAO dogDAO = new DogDAO();

  public List<DogDTO> getSeniorDogNames() {
    return dogDAO.findAllDogs().stream()
        // 1. 過濾：只保留 5 歲以上的狗
        .filter(entity -> entity.getAge() > 5)
        // 2. 轉換：將 Entity 轉成 DTO，並加入分類邏輯
        .map(entity -> {
          String cat = entity.getAge() > 10 ? "Old Dog" : "Adult Dog";
          return new DogDTO(entity.getName(), cat);
        })
        // 3. 收集：轉回 List
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    // 初始化 Service
    DogService dogService = new DogService();

    // 執行邏輯並取得結果
    List<DogDTO> result = dogService.getSeniorDogNames();

    // 列印結果
    System.out.println("----- 測試結果 -----");
    result.forEach(System.out::println);
    // 預期輸出:
    // DogDTO(name=Max, cat=Adult Dog)
    // DogDTO(name=Lucy, cat=Old Dog)
    // DogDTO(name=Jack, cat=Adult Dog)
  }
}