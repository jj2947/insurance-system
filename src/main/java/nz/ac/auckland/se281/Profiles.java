package nz.ac.auckland.se281;

public class Profiles {

  private String userName;
  private String age;

  public Profiles(String userName, String age) {
    this.userName = userName;
    this.age = age;
  }

  public String getAge() {
    return age;
  }

  public String getUserName() {
    return userName;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
