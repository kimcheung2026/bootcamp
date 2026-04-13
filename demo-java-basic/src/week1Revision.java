public class week1Revision {
  public static void main (String [] args) {

  
  // 8 Primitives + String
  byte b1 = 5; //-128 to 127
  short s1 = 30000; //-3xxxx
  int l1 = 2_100_000_000; // -2_100_000_000 to
  //long l1= 2_200_000_000; // 系統假設所有值 INT
  long l2= 2_200_000_000L;

  double d1 = 10.99;  //統假設所有小數值  double value
  float f1 = 10.99f;

  boolean bo1 = true;
  char ch1 = 'a'; // 97 -> ascII    0-6XXXX

  //Math (+,-,*,/)
   // overflow
   //down casting int -> byte.
   //divide 0
   // double + double (0.1+0.2)

  int number = 2_100_000_000;
   //  int + long -> long

   // down cast (Take my own risk)
   // byte +byte -> int + int
   // short + short -> int + int -> int
   // byte + short -> int + int -> int

  byte by1 = 100;
  short sh = Short.MAX_VALUE;
  short sh2 = (short) (by1 + sh);

   // double + double -> double  (problem to human)


   // String
  String str1 = "Hello";
   // .length()
   // .charAt(0)
   // .equals()  true /false

   // .indexOf('o')                       return int
   // .lastIndexOf("XXX")                 return int
   // .contains(" ")  true/ false         return boolean
   // .substring(0 , 4 )  first to end                       return String
   // .replace("ll","xxx")                return String
   // .starsWith("he")                    return boolean
   // .endsWith("lllo")                   return boolean
   // .isEmpty()  check ""                return boolean
   // .isBlank()  check " "               return boolean
   // .toLowerCase()  to downgrade All char  return String
   // .toUpperCase()  to upgrade All char    return String
   // .equalsIgnoreCase(str1)             return String
   // str1.compareto(str2)                return int 
   // str1.concat(str2)                   return String

// Operator
// Math: + - * / % ++ -- +=  -= *= /=
// primitives Comparsion  != == > < >= <=  !
// String Comparsion  (method)  



// IF + Switch
// 加break 
//Check Single Value Only (not range checking
// Switch ()  case:  break;  default:
  



// For Loop
String s = "hello";
for (int i =0; i < s.length(); i++) {
  System.out.println(s.charAt(i));
}
String t1 = "";
String t2 = "";
for (int i = 0 ; i < s.length(); i++) {
  if (i % 2 == 0) {
    t1 += s.charAt(i);
  } else { t2 += s.charAt(i);

  }
}
  System.out.println(t1);
  System.out.println(t2);
  // counting -> target
  // how many 'l' in the string.
  int countl = 0;
  for (int i = 0 ; i < s.length(); i++) {
    if (s.charAt(i) == 'l') {
      countl++;
    }
  }
  System.out.println(countl);
  





}





}