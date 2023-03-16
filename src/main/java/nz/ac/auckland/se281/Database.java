package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Database {

  // Creates the arraylist that will store all the usernames for the profiles created
  private ArrayList<String> userNames = new ArrayList<String>();

  // Creates the arraylist that will store all the ages for the profiles created
  private ArrayList<String> ages = new ArrayList<String>();

  // Initialises the variables
  private String userName;
  private String age;
  private static int size;

  // Constructor that initialises userName, age and size
  public Database() {
    this.userName = " ";
    this.age = " ";
    size = 0;
  }

  // Method that returns the age of the current profile
  public String getAge() {
    return age;
  }

  // Method that returns the userName of the current profile
  public String getUserName() {
    return userName;
  }

  // Sets the age as the age that was inputted
  public void setAge(String age) {
    this.age = age;
  }

  // Sets the userName as the username that was inputted
  public void setUserName(String userName) {
    this.userName = userName;
  }

  // Adds the username that was inputted to the userNames arraylist
  public void addUserName() {
    userNames.add(this.userName);
    size++;
  }

  // Adds the age that was inputted to the ages arraylist
  public void addAge() {
    ages.add(this.age);
  }

  // Gets an username from the userNames array at a specific index position
  public String getUserNames(int indexPos) {
    return userNames.get(indexPos);
  }

  // Gets an age from the ages array at a specific index position
  public String getAges(int indexPos) {
    return ages.get(indexPos);
  }

  // Gets the size, which is how many profiles are in the database
  public static int getSize() {
    return size;
  }

  // Checks if the database alredy has a usernme in it
  public boolean alreadyContains(String userName) {
    if (userNames.contains(userName) == true) {
      return true;
    } else {
      return false;
    }
  }
}
