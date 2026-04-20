// public class InvalidEmailException extends RuntimeException //! Unchecked Exception
public class InvalidEmailException extends Exception { // ! Checked Exception[]
  public static void main(String[] args) {
    new InvalidEmailException();

    public static void sendEmail(String emailAddress) {
      // Step1
      if (!isValid(emailAddress)) {
        throw new InvalidEmailException(); // simliar "return"
        //! "return;" -> does not present any problem
        //! throw (return) exception object 
      }
      sendEmail(emailAddress, "Welcome to Bootcamp.");
    }

    public static void sendEmail(String emailAddress, String emailSubject) {
    

    }
  }

}
