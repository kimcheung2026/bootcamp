package com.bootcamp.demo;

import java.util.HashMap;
import java.util.Map;

public static void main(String[]args){
// 1. 建立 HashMap (Key: String, Value: Integer)
HashMap<String,Integer>fruitInventory=new HashMap<>();

// 2. 新增數據 (put)
fruitInventory.put("Apple",50);fruitInventory.put("Banana",30);fruitInventory.put("Cherry",100);

// 3. 取得數據 (get)
int appleCount=fruitInventory.get("Apple");System.out.println("蘋果數量: "+appleCount);

// 4. 檢查是否存在 Key 或 Value (containsKey / containsValue)
if(fruitInventory.containsKey("Banana")){System.out.println("香蕉在庫");}

// 5. 移除數據 (remove)
fruitInventory.remove("Cherry");

// 6. 取得大小 (size)
System.out.println("水果種類總數: "+fruitInventory.size());

// 7. 遍歷 HashMap (Iterating)
System.out.println("--- 目前庫存清單 ---");for(String name:fruitInventory.keySet()){System.out.println(name+": "+fruitInventory.get(name));}

// 8. 清空所有內容 (clear)
fruitInventory.clear();}}}
