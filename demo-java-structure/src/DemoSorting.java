import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DemoSorting {
  public static void main(String[] args) {
    // Collection.class

    // Collections
    int[] arr = new int[] { 3, 9, 11, 4, 6, -3 };
    Arrays.sort(arr); // Pass by address
    System.out.println(Arrays.toString(arr));

    String[] arr2 = new String[] { "bcd", "ab", "Peter", "banana" };
    Arrays.sort(arr2);
    System.out.println(Arrays.toString(arr2));

    List<Person1> persons = new ArrayList<>();
    persons.add(new Person1(80));
    persons.add(new Person1(40));
    persons.add(new Person1(20));
    persons.add(new Person1(70));
    persons.add(new Person1(60));

    // ! sort(persons) -> Comparable
    Collections.sort(persons);
    System.out.println(persons);
    Collections.sort(persons, new SortByAgeAsc());
    System.out.println(persons);

  }
}
