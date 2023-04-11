package nz.ac.auckland.se281;

// Profile class which creates instances of a profile
public class Profile {

  // Declares variables
  private String userName;
  private String age;
  private boolean loadStatus;
  private int numPolicies;

  // Constructor which initialises userName and age vaariables
  public Profile(String userName, String age, boolean loadStatus, int numPolicies) {
    this.userName = userName;
    this.age = age;
    this.loadStatus = loadStatus;
    this.numPolicies = numPolicies;
  }

  // Gets the username of a profile instance
  public String getUserName() {
    return this.userName;
  }

  // Gets the age of a profile instance
  public String getAge() {
    return this.age;
  }

  // Returns whether or not a profile is loaded
  public boolean getLoadStatus() {
    return this.loadStatus;
  }

  // Loads or unloads a profile
  public void setLoadStatus(boolean loadStatus) {
    this.loadStatus = loadStatus;
  }

  public int getNumPolicies() {
    return numPolicies;
  }
}
