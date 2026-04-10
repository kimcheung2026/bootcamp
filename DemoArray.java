import java.util.Arrays;

public class DemoArray {
  public static void main(String[] args) {
    // int type
    int age = 3;
    int johnAge = 18;
    int maryAge = 17;

    // Array : store a set of same type values
    // Array is an unit in memory
    int[] ages = new int[100];
    // First Box
    ages[0] = age;
    ages[1] = johnAge;
    ages[2] = maryAge;

    int temp = ages[1];
    ages[1] = ages[2];
    ages[2] = temp;

    System.out.println(ages[0]);
    System.out.println(ages[1]);
    System.out.println(ages[2]);

    for (int i =0; i < ages.length; i++) {
      System.out.println(ages[i]);
    }
    //! System.out.println(ages[-1]); bug              runtime error
    //! System.out.println(ages[3]);  bug over range   runtime error

    //declare length 100 int array (0-99)
    int[] arr = new int[10]; //default value 0
    // print out all values

    //string[] name = new string[100];
    //String name = "hello";



    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
   // aasign 100 - 199 into the array
    for (int i = 0; i < arr.length; i++) {
    arr[i] = i + 100;
    }

    // Two ways to declare an array (with known value set)
    char[] chs = new char[4];
    chs[0] = 'a';

    double[] prices = new double[] {99.99, 50.3 , 100.0};
    // print out all prices
    for(int i =0; i < prices.length; i++) {
      System.out.println(prices[i]);
    }
    // sum up all prices 
    double totalPrice = 0.0;
    for (int i = 0; i< prices.length; i++) {
      totalPrice += prices[i];
    }
    System.out.println("total price=" + totalPrice);

    // find the min value          Loop -> view all value
    double minPrice = prices[0];
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      }
    }
    // int[] , double[], String[], char[]
    char[] chs2 = new char[] {'a', 'e', 'i', 'o', 'u'};
    String name = "Myoy";
    // loop: check 
    for (int i =0; i < name.length(); i++) {
      if (name.indexOf(chs2[i]) !=  -1)
        System.out.println("found" + " it is " + chs2[i]);
      break;
    }
    // outer loop and inner loop
    boolean found = false;
    for (int i = 0; i < name.length(); i++) {
      for (int j = 0; j < chs2.length; j++) {
        if (name.charAt(i) == chs2[j]) {
          found = true;
          System.out.println("found" + " it is " + chs2[j]);
          break; // break inner loop
          
        }
        if (found){
        break; // break outer loop
        }
      }
    }
    // move the first number to the tail-> 4, 99, 55, 17, 100
    int number [] = new int[] {4, 99, 55, 17, 100};
    for (int i = 0; i < number.length - 1; i++) {
       int temp1 = number[i];
       number[i] = number[i+1];
       number[i+1] = temp1;
    }
    System.out.println(Arrays.toString(number));

    //Sorting
    int[] arr3 = new int[] {100, 4 , 200 , 55, 17};
    // Move the max number to the tail 
    for (int i = 0; i < arr3.length - 1; i++) {
       if ((arr3[i]) > arr3[i+1] ){
        int temp1 = arr3[i];
        arr3[i] = arr3[i+1];
        arr3[i+1] = temp1;
       }
      }
    System.out.println(Arrays.toString(arr3));

    //Sorting  
    int[] arr4 = new int[] {100, 4 , 200 , 55, 17};
    for (int i = 0; i < arr4.length - 1; i++) { // move  max number
        for (int j = 0; j < arr4.length - i -1; j++) { // move  you need for max number //! -i shorter time
          if ((arr4[j]) > arr4[j+1] ){
          int temp1 = arr4[j];
          arr4[j] = arr4[j+1];
          arr4[j+1] = temp1;
          
          }
        }
      }
    System.out.println(Arrays.toString(arr4));

    String str = "abcdefg"; //reverse the string
    for (int i = 0; i < str.length() - 1; i++) { // move  max number
        reversedString += str.charAt(str.length() -1-i);
          }
        System.out.println(str);
        }

  }
}
