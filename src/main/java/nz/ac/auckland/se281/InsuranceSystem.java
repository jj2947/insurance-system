package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

import java.util.ArrayList;

public class InsuranceSystem {

  // Creates the arraylist that will store all the user profiles
  private ArrayList<String> userNames = new ArrayList<String>();

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
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(String.valueOf(i + 1), userNames.get(i),
            ages.get(i));
      }

    }
  }

  public void createNewProfile(String userName, String age) {
    userNames.add(userName);
    ages.add(age);
    System.out.println("New profile created for " + userName + " with age " + age + ".");
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
