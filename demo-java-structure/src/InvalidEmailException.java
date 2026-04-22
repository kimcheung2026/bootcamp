// public class InvalidEmailException extends RuntimeException { // ! Unchecked Exception
public class InvalidEmailException extends Exception { // ! Checked Exception
  // attribute

  // constructor

  // method

  public static void main(String[] args) {
    // new InvalidEmailException();
    boolean isSignUp = true;
    String userEmail = "johnlau@gmail.com";
    if (isSignUp) {
      try {
        sendWelcomeEmail(userEmail);
      } catch (InvalidEmailException e) {
        // ... recoverable
        // if cannot recover, return status back to trigger point (Frontend)
      }
    }

    // No Try-catch
    if (isSignUp) {
      // ! try-catch is required if InvalidEmailException is CheckedException
      // ! try-catch is NOT required if InvalidEmailException is UncheckedException
      // sendWelcomeEmail(userEmail);
    }
  }

  // Wrong email address
  // send Welcome Email -> Procedure -> Action (throw)
  public static void sendWelcomeEmail(String emailAddress)
      throws InvalidEmailException {
    // Step1
    if (!isValidEmail(emailAddress)) {
      throw new InvalidEmailException(); // simliar "return"
      // ! "return;" -> does not present any problem
      // ! throw (return) exception object
    }
    sendEmail(emailAddress, "Welcome to Bootcamp.");
  }

  public static void sendEmail(String emailAddress, String emailSubject) {
    // ....
  }

  public static boolean isValidEmail(String emailAddress) {
    // ....
    return false;
  }
}