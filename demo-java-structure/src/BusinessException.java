public class BusinessException extends RuntimeException {
  private int code;

  private BusinessException(int code, String message) {

    super(message);
    this.code = code;
  }

  public static BusinessExeption of(SysError sysError) {
    return new BusinessException(sysError.getCode(), sysError.getMessage());

  }

  public int getCode() {
    return this.code;
  }
}
