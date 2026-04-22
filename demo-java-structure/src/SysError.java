public enum SysError {
  TIMEOUT(100000, " Connection timeout.");

  private int code;
  private String message;

  Private SysError(int code, String messge) {
    this.code = code;
    this.message = message;
  }

}
