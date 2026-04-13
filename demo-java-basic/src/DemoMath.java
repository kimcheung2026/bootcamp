import java.util.ArrayList;
import java.util.Collections;

public class DemoMath {
  public static void main (String[] args) {
    //! PI
    double pi = Math.PI;
    // circle area
    double radius = 3.5;
    double area = radius * radius * Math.PI;
    System.out.println(Math.round(area));

    //! sqrt
    System.out.println(Math.sqrt(9)); //3.0
    System.out.println(Math.sqrt(99)); //9.9498743710662;

    //! round
    System.out.println(Math.round(10.453)); //10


    //! pow
    double result = Math.pow(2,3); //implicit promotion 
    System.out.println(result); // 8.0

    double bmi = 76 / Math.pow(1.76, 2); //int /double -> double
    System.out.println(bmi);

    //! abs
    int x = -2; // 2/ -2 
    if ( x < 0) {
      x = x * -1;
    }
    System.out.println(x); // 2

    int y = -3;
    System.out.println(Math.abs(y)); //3

    //! max / min
    int[] arr = new int[] {10, 4 , 8, 99, -2};
    int max = arr[0];
    int min = arr[0];
    for ( int i = 0; i < arr.length; i++) {
      max = Math.max(arr[i], max);
      min = Math.min(arr[i], min);

    }
    System.out.println(max);


    // ! floor , cell
    System.out.println(Math.floor(10.9)); //10

    //! random
    double number = Math.random(); //0 -1 
    System.out.println(number);

    // 100 1100 
    double number1 = Math.random() * 1000 + 100; 
    System.out.println(number1);

    //1 - 49
    int marksix = 6;
    double[] arr1 = new double[marksix];
    for ( int i = 0 ; i < arr1.length; i++) {
      arr1[i] = Math.random() * 49 + 1; 

    System.out.println(Math.round(arr1[i]));
    }


    int markSix1 = 6;
    // AI 提供 功能未清楚 待查
        ArrayList<Integer> list = new ArrayList<>();

        // 把 1~49 全部加入列表
        for (int j = 1; j <= 49; j++) {
            list.add(j);
        }

        // 随机打乱顺序
        Collections.shuffle(list);

        // 输出前6个不重复数字
        System.out.println("不重复的6个号码：");
        for (int j = 0; j < markSix1 ;j++) {
            System.out.print(list.get(j) + " ");
        }

    
    
  }
}
