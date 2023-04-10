package nz.ac.auckland.se281;

// Profile class which creates instances of a profile
public class Profile {

  // Declares variables
  private String userName;
  private String age;
  private boolean loadStatus;

  // Constructor which initialises userName and age vaariables
  public Profile(String userName, String age, boolean loadStatus) {
    this.userName = userName;
    this.age = age;
    this.loadStatus = loadStatus;
  }

  // Gets the username of a profile instance
  public String getUserName() {
    return this.userName;
  }

  // Gets the age of a profile instance
  public String getAge() {
    return this.age;
  }

  public boolean getLoadStatus() {
    return this.loadStatus;
  }

  public void setLoadStatus(boolean loadStatus) {
    this.loadStatus = loadStatus;
  }
}
