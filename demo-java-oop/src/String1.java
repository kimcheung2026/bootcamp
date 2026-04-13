public class String1 {
  private char[] chs;
  private boolean isReplaced = false;
  
  //constructor  构造方法：接收字符串，初始化字符数组
    public String1(String )
    public String1(String value) {
        // 把传入的字符串转成字符数组，赋值给成员变量 chs
        this.chs = new char[value.length()];
        int idx = 0;
        for (int i = 0 ; i < value.length(); i++) {
          this.chs[idx] = value.charAt(i); //this.chs[idx++] = value.charAt(i);
          idx++;
        }
    }
    
    public String replace(char from, char to) {
      char[] ch2 = new char[this.chs.length];
      if (!isReplaced){
        isReplaced = true;
        for (int i = 0; i < this.chs.length; i++) {
          if (chs[i] == from) {
              ch2[i] = to;        // 替换
          } else {
              ch2[i] = chs[i];    // 不替换，复制原字符
              }
          }
          //char array -> String (for loop)
          // true = replace this.chs to ch2
          return String.valueOf(ch2);
      } else {
        //false = Err -> this.chs
        return String.valueOf(this.chs);
      }
    }
    public String toString() {
      return String.valueOf(this.chs);
    }



    // 实现 length() 方法：返回字符串长度（字符数组长度）
    public int length() {
        return this.chs.length;
    }

    // 实现 charAt() 方法：返回指定索引的字符
    public char charAt(int index) {
        return this.chs[index];
        }
  //...
  public static void main (String[] args) {
    String1 str = new String1("hello");
    System.out.println(str.length()); //5
    System.out.println(str.charAt(0)); //h

    // replace('l', 'x')
    System.out.println(str.replace('l','x'));
    System.err.println(str);

    String s = new String();
    System.out.println(s);

    //






  }
  
}
