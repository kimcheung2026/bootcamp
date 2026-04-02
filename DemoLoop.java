public class DemoLoop {
  public static void main (String[] args){
    // hello
    System.out.println("hello");
    System.out.println("hello");
    System.out.println("hello");

    // For Loop
    // intialization -> int i =0;
    // continue criteria -> i < 3
    // Each Iteration End -> i++

    for (int i = 0; i < 3; i++) {
      System.out.println("bye");
    }
    // Step 1 int 1 =0 
    // Step 2 check if i < 3
    // Step 3 Print bye
    // Step 4 i++
    // Step 5 check if i < 3
    // Step 6 Print bye
    // Step 7 i++
    // Step 8 check if i < 3
    // Step 9 Print bye
    // Step 10 i++
    // Step 11 check if i < 3
    // Step 12 exit loop

    for(int i = 0; i < 10; i++) {
      if ( i % 2 == 0) {
        System.out.println(i);
      }
    }
    // Print the numbers between 0- 99 , which divided by 3, and it is greater than 50
    for(int i = 0; i < 100; i++) {
      if ( i % 3 == 0 && i > 50) { //time and speed is important (i>50 && i%3 ==0) better
        System.out.println(i);
      }
    }
    // hello
    // Find if character 'l' exits (Not use contain/ indexOf)
    String s = "hello";
    boolean isTargetExists = false;
    for (int i = 0; i < s.length(); i++) {
      System.out.println(s.charAt(i));
      if (s.charAt(i) == 'l') {
        isTargetExists = true;
        break;   // break nearest loop
      }
    }
      System.out.println(isTargetExists);
    
      
      // Find the largest even digit
      String s2 = "947852106";
      int max = Integer.MIN_VALUE;
      for (int i = 0; i< s2.length(); i++) {
        int digit = s2.charAt(i) - '0';
        if (digit % 2 == 0) {
          if (digit > max) {
            max = digit;
          }
        }
        System.out.println(max);
      }
      String s3 = "8A3ahs0nd3"; //ahsnd
      String output ="";
      for (int i = 0; i< s3.length(); i++) {
        boolean isAlphabet = s3.charAt(i) >=97 && s3.charAt(i) <=122;
        if (isAlphabet) {
          output += s3.charAt(i);
        }
      }
      System.out.println(output);


      // "725094849"
      //Find the largest index of the largest digit
      // 8
        String s = "725094849";
        
        // 第一步：先假设最大数字是 0，最大索引是 0
        char maxChar = '0';
        int maxIndex = 0;

        // 遍历每一个字符
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            // 如果当前数字 >= 已记录的最大数字
            // 关键：用 >= 才能保留【最后一次】出现的索引
            if (current >= maxChar) {
                maxChar = current;  // 更新最大数字
                maxIndex = i;       // 更新最后出现的索引
            }
        }

        // 输出结果：索引是 8
        System.out.println(maxIndex); // 输出：8
    }
}




    }
}
