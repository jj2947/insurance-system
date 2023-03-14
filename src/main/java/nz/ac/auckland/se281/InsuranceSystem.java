package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  // Creates the arraylist that will store all the usernames for the profiles created
  private ArrayList<String> userNames = new ArrayList<String>();

  // Creates the arraylist that will store all the ages for the profiles creates
  private ArrayList<String> ages = new ArrayList<String>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    if (userNames.size() == 0) {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");

    } else if (userNames.size() == 1) {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", ":");
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage("1", userNames.get(0), ages.get(0));

    } else {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(userNames.size()), "s", ":");

      for (int i = 0; i < userNames.size(); i++) {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            String.valueOf(i + 1), userNames.get(i), ages.get(i));
      }
    }
  }

  public void createNewProfile(String userName, String age) {

    userName = userName.toLowerCase();
    userName = userName.replace(userName.charAt(0), Character.toUpperCase(userName.charAt(0)));

    boolean isInt = false;

    for (int i = 0; i < age.length(); i++) {
      if (Character.isDigit(age.charAt(i))) {
        isInt = true;
      }
    }

    if (userNames.contains(userName) == true) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    } else if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    } else if (isInt == true && Integer.valueOf(age) >= 0) {
      userNames.add(userName);
      ages.add(age);
      MessageCli.PROFILE_CREATED.printMessage(userName, age);
    } else {
      MessageCli.INVALID_AGE.printMessage(age, userName);
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
