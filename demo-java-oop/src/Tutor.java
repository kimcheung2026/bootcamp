// Java Class (blueprint -> object)
public class Tutor {
  //Attribute
  private String emailAddress;
  private String whatsappNumber;
  private String wechatId;
  private String phoneNumber;

  //Method -> Presentation (APIE : Encapsulation)
  public String getInfo() {
    return this.whatsappNumber +" " + this.emailAddress;
  }
  
  //instance Method (Object Method)
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
  public String getEmailAddress() { //String -> return Type
    return this.emailAddress;  // return String Value
  }
}
