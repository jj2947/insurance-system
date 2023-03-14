package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Database {

  // Creates the arraylist that will store all the usernames for the profiles created
  private ArrayList<String> userNames = new ArrayList<String>();

  // Creates the arraylist that will store all the ages for the profiles creates
  private ArrayList<String> ages = new ArrayList<String>();

  private String userName;
  private String age;

  public Database(String userName, String age) {
    this.userName = userName;
    this.age = age;
  }

  public Database() {
    this.userName = "";
    this.age = "";
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

  public void addUserName() {
    userNames.add(this.userName);
  }

  public void addAge() {
    ages.add(this.age);
  }

  public String getUserNames(int indexPos) {
    return userNames.get(indexPos);
  }

  public String getAges(int indexPos) {
    return ages.get(indexPos);
  }

  public int getSize() {
    return userNames.size();
  }

  public boolean alreadyContains(String userName) {
    if (userNames.contains(userName) == true) {
      return true;
    } else {
      return false;
    }
  }
}
