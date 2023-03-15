package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Database {

  // Creates the arraylist that will store all the usernames for the profiles created
  private ArrayList<String> userNames = new ArrayList<String>();

  // Creates the arraylist that will store all the ages for the profiles creates
  private ArrayList<String> ages = new ArrayList<String>();

  private String userName;
  private String age;
  private static int size;

  public Database() {
    this.userName = "";
    this.age = "";
    size = 0;
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
    size++;
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

  public static int getSize() {
    return size;
  }

  public boolean alreadyContains(String userName) {
    if (userNames.contains(userName) == true) {
      return true;
    } else {
      return false;
    }
  }
}
