package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  private ArrayList<Profile> profile = new ArrayList<Profile>();
  private boolean alreadyContains;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).\
  }

  // Implements the PRINT_DB command
  public void printDatabase() {

    // Prints the message for an empty database
    if (profile.size() == 0) {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");

      // Prints the message for a database with one profile
    } else if (profile.size() == 1) {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", ":", "");
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
          "1", profile.get(0).getUserName(), profile.get(0).getAge());

      // Prints the message for a database with 3 or more profiles
    } else {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(profile.size()), "s", ":");

      for (int i = 0; i < profile.size(); i++) {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            String.valueOf(i + 1), profile.get(i).getUserName(), profile.get(i).getAge());
      }
    }
  }

  public void createNewProfile(String userName, String age) {

    // Makes sure the username is in title case
    userName = userName.toLowerCase();
    userName = userName.replace(userName.charAt(0), Character.toUpperCase(userName.charAt(0)));

    boolean isInt = false;

    // Checks if an inputted age is an integer
    for (int i = 0; i < age.length(); i++) {
      if (Character.isDigit(age.charAt(i))) {
        isInt = true;
      }
    }

    for (int i = 0; i < profile.size(); i++) {
      if (userName.equals(profile.get(i).getUserName())) alreadyContains = true;
    }

    Profile newProfile = new Profile(userName, age);

    // Prints the message for when the database already contains the username
    if (alreadyContains) {

      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(newProfile.getUserName());

      // Prints the message for a username that is too short
    } else if (newProfile.getUserName().length() < 3) {

      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(newProfile.getUserName());

      // Prints the message for when a profile is created successfully
    } else if (isInt == true && Integer.valueOf(newProfile.getAge()) >= 0) {

      profile.add(newProfile);
      MessageCli.PROFILE_CREATED.printMessage(newProfile.getUserName(), newProfile.getAge());

      // Prints the message for an invalid age
    } else {
      MessageCli.INVALID_AGE.printMessage(newProfile.getAge(), newProfile.getUserName());
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
