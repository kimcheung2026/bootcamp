import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DataStructureExercise1 {

  public static final String findStudentById(ArrayList<Student1> students, int id) {
    // 使用 for-each 迴圈遍歷清單
    for (Student1 s : students) {
      // 假設你的 Student 類別有 getId() 方法
      if (s.getId() == id) {
        return s.getName(); // 找到後回傳名字
      }
    }
    // 如果整個迴圈跑完都沒找到
    return "Student not found";
  }

  public static void main(String[] args) {
    // Exercise 1: Array List Basic Operations

    // 1a. Create an ArrayList of integers.
    // 1b. Add the following numbers: 10, 20, 30, 40, and 50.
    // 1c. Print all the elements in the list.
    // 1d. Remove the number 30 from the list.
    // 1e. Print the size of the list.
    ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(10);
    numbers.add(20);
    numbers.add(30);
    numbers.add(40);
    numbers.add(50);
    System.out.println(numbers);
    numbers.remove(Integer.valueOf(30));
    System.out.println(numbers.size());

    // Exercise 2: Search and Update

    // 2a. Create an ArrayList of strings to store names of fruits: "Apple",
    // "Banana", "Mango", and
    // "Orange".
    // 2b. Check if "Grapes" exists in the list.
    // 2c. If it doesn’t exist, add it to the list.
    // 2d. Update "Mango" to "Peach".
    // 2e. Print the final list.
    ArrayList<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana"//
        , "Mango", "Orange"));

    if (!fruits.contains("Grapes")) {
      fruits.add("Grapes");
    }
    fruits.replaceAll(s -> s.contains("Mango") ? "Peach" : s);
    // Collections.replaceAll(fruits, "Mango", "Peach");
    System.out.println(fruits);

    // Exercise 3: Remove Duplicates

    // 3a. Create an ArrayList with the following numbers: 10, 20, 10, 30, 40, 20,
    // 50.
    // 3b. Remove duplicates from the list using a HashSet.
    // 3c. Print the list after removing duplicates.
    ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(10, 20, 10, 30, 40, 20, 50));
    HashSet<Integer> set = new HashSet<>();
    HashSet<Integer> duplicates = new HashSet<>();
    for (Integer s : numbers1) {
      // 如果 add() 回傳 false，代表 set 裡面已經有這個元素了
      if (!set.add(s)) {
        duplicates.add(s);
      }
    }
    System.out.println(set);
    System.out.println(duplicates);

    // Exercise 4: HashSet Basic Operations

    // 4a. Create a HashSet of strings to store country names: "USA", "India",
    // "China", "Japan".
    // 4b. Add "Canada" to the set.
    // 4c. Add "India" again. Print the result.
    // 4d. Print all elements in the set.
    HashSet<String> set1 = new HashSet<>(Set.of("USA", "India", "China", "Japan"));
    set1.add("Canada");
    set1.add("India");
    boolean isAdded = set1.add("India");
    System.out.println("是否成功加入 India: " + isAdded);
    System.out.println(set1);

    // Exercise 5: Check the numbers

    // 5a. Create a HashSet of numbers: 1.1, 2.2, 3.3, 4.4, 5.5
    // 5b. Check if the set contains the number 3.3
    // 5c. Remove the number 2.2 from the set.
    // 5d. Print the size of the set.
    HashSet<BigDecimal> set2 = new HashSet<>(Set.of(BigDecimal.valueOf(1.1), //
        BigDecimal.valueOf(2.2), BigDecimal.valueOf(3.3), BigDecimal.valueOf(4.4), //
        BigDecimal.valueOf(5.5)));
    System.out.println(set2.contains(BigDecimal.valueOf(3.3)));
    set2.remove(BigDecimal.valueOf(2.2));
    System.out.println(set2.size());
    System.out.println(set2);

    // Exercise 6: Intersection of Sets

    // 6a. Create two HashSets:
    // 6b. Set 1: 10, 20, 30, 40
    // 6c. Set 2: 30, 40, 50, 60
    // 6d. Find the common numbers of the two sets.
    // 6e. Print the resulting set.
    HashSet<Integer> set3 = new HashSet<>(Set.of(10, 20, 30, 40));
    HashSet<Integer> set4 = new HashSet<>(Set.of(30, 40, 50, 60));
    HashSet<Integer> commonSet = new HashSet<>(set3);
    commonSet.retainAll(set4); // 交集方法
    System.out.println(commonSet);

    // Exercise 7: Convert HashSet to ArrayList

    // 7a. Create a HashSet with the following String: "Cherry", "Steve", "Chole",
    // "Jenny", "Vicky".
    // 7b. Convert the HashSet to an ArrayList.
    // 7c. Print the converted list.
    HashSet<String> names = new HashSet<>(Set.of("Cherry", "Steve", "Chole", //
        "Jenny", "Vicky"));
    // 排序：HashSet 是無序的，轉成 ArrayList 後你可以使用 Collections.sort() 進行排序。
    // 索引存取：ArrayList 可以使用 get(index) 透過索引值抓取特定位置的元素，而 Set 不行。
    ArrayList<String> namelist = new ArrayList<>(names);
    System.out.println(namelist);

    // Exercise 8: ArrayList of Students
    // 8a. Create an ArrayList to store Student objects.
    // Add the following students:
    // ID: 1, Name: Alice
    // ID: 2, Name: Bob
    // ID: 3, Name: Charlie
    // 8b. Iterate over the ArrayList and print each student's details.
    // 8c. Remove the student Bob.
    // 8d. Write a static method to search for a student by ID and return their
    // name. If the student is
    // not found,
    // return "Student not found".
    // 8e. Create another ArrayList to store student with name starts with 'A'
    ArrayList<Student1> students = new ArrayList<>();
    students.add(new Student1(1, "Alice"));
    students.add(new Student1(2, "Bob"));
    students.add(new Student1(3, "Charlie"));
    System.out.println(students);
    students.remove(new Student1(2, "Bob"));
    String result = findStudentById(students, 2); // line 10 - 20 (8d)
    System.out.println("Search result: " + result);
    ArrayList<Student1> nameWithA = new ArrayList<>();
    for (Student1 s : students) {
      if (s.getName().charAt(0) == 'A') {
        nameWithA.add(s);
      }
    }
    System.out.println(nameWithA);

    // Exercise 9: HashSet of Students
    // 9a. Create two HashSets of Student objects:
    // Set 1: Alice (ID: 1), Bob (ID: 2), Charlie (ID: 3)
    // Set 2: Bob (ID: 2), Charlie (ID: 3), David (ID: 4)
    // 9b. Find the common students of the two sets
    // 9c. Print the result.
    HashSet<Student1> set5 = new HashSet<>(Set.of(new Student1("Alice", 1), new Student1("Bob", 2//
    ), new Student1("Charlie", 3)));
    HashSet<Student1> set6 = new HashSet<>(Set.of(new Student1("Bob", 2), new Student1("Charlie", 3//
    ), new Student1("David", 4)));
    HashSet<Student1> commonSet1 = new HashSet<>(set5);
    commonSet1.retainAll(set6); // 交集方法
    for (Student1 s : commonSet1) {
      System.out.println(s.toString1());
    }
    System.out.println(commonSet1);

  }

  public static class Student1 {
    private int id;
    private String name;

    // Constructor

    public Student1(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public Student1(String name, int id) {
      this.id = id;
      this.name = name;
    }

    // getter, setter, etc.
    public int getId() {
      return this.id;
    }

    public String getName() {
      return this.name;
    }

    public void setId(int id) {
      this.id = id;
    }

    public void setName(String name) {
      this.name = name;
    }

    // 建立 equals: 判斷兩個 Student 物件的內容是否相同
    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true; // 如果記憶體位址相同，直接回傳 true
      if (o == null || getClass() != o.getClass())
        return false; // 判斷是否為空或類別不同
      Student1 student = (Student1) o;
      return id == student.id && Objects.equals(name, student.name);
    }

    // 建立 hashCode: 根據內容算出一個雜湊值
    @Override
    public int hashCode() {
      return Objects.hash(id, name);
    }

    // 建議同時建立 toString，方便之後列印 ArrayList 查看結果
    @Override
    public String toString() {
      return "id: " + id + ", Name: " + name;
    }

    public String toString1() {
      return name + " (id: " + id + ")";
    }
  }
}
