package nz.ac.auckland.se281;

// Profile class which creates instances of a profile
public class Profile {

  // Declares variables
  private String userName;
  private String age;

  // Constructor which initialises userName and age vaariables
  public Profile(String userName, String age) {
    this.userName = userName;
    this.age = age;
  }

  // Gets the username of a profile instance
  public String getUserName() {
    return this.userName;
  }

  // Gets the age of a profile instance
  public String getAge() {
    return this.age;
  }
}
