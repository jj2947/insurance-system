package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  // Creates an arraylist that stores profile instances
  private ArrayList<Profile> database = new ArrayList<>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).\
  }

  // Implements the PRINT_DB command
  public void printDatabase() {

    // Prints the message for an empty database
    if (database.size() == 0) {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");

      // Prints the message for a database with one profile
    } else if (database.size() == 1) {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", ":", "");
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
          "1", database.get(0).getUserName(), database.get(0).getAge());

      // Prints the message for a database with 3 or more profiles
    } else {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(database.size()), "s", ":");

      // Loops through the database arraylist to get the usernames and ages
      for (int i = 0; i < database.size(); i++) {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            String.valueOf(i + 1), database.get(i).getUserName(), database.get(i).getAge());
      }
    }
  }

  // Implements the CREATE_PROFILE command
  public void createNewProfile(String userName, String age) {

    // Declares variables
    boolean alreadyContains = false;
    boolean isInt = false;

    // Makes sure the username is in title case
    userName = userName.toLowerCase();
    userName = userName.replace(userName.charAt(0), Character.toUpperCase(userName.charAt(0)));

    // Checks if an inputted age is an integer and assigns it to the vairble isInt
    for (int i = 0; i < age.length(); i++) {
      if (Character.isDigit(age.charAt(i))) {
        isInt = true;
      } else {
        isInt = false;
        break;
      }
    }

    // Checks if the database already contains the username and assigns the boolean value to
    // alreadyContains
    for (int i = 0; i < database.size(); i++) {
      if (userName.equals(database.get(i).getUserName())) {
        alreadyContains = true;
      }
    }

    // Makes a new instance of a profile
    Profile newProfile = new Profile(userName, age);

    // Prints the message for when the database already contains the username
    if (alreadyContains) {

      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(newProfile.getUserName());

      // Prints the message for a username that is too short
    } else if (newProfile.getUserName().length() < 3) {

      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(newProfile.getUserName());

      // Prints the message for an invalid age
    } else if (!isInt || Integer.parseInt(newProfile.getAge()) < 0) {

      MessageCli.INVALID_AGE.printMessage(newProfile.getAge(), newProfile.getUserName());

      /* Prints the message for when a profile is created successfully and adds the profile
      instance to the database arraylist*/
    } else {
      database.add(newProfile);
      MessageCli.PROFILE_CREATED.printMessage(newProfile.getUserName(), newProfile.getAge());
    }
  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
