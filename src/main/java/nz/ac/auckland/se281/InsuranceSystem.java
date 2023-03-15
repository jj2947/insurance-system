package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  // Creates a database instance
  private Database database = new Database();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).\
  }

  // Implements the PRINT_DB command
  public void printDatabase() {

    if (Database.getSize() == 0) {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");

    } else if (Database.getSize() == 1) {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", ":", "");
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
          "1", database.getUserNames(0), database.getAges(0));

    } else {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(Database.getSize()), "s", ":");

      for (int i = 0; i < Database.getSize(); i++) {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            String.valueOf(i + 1), database.getUserNames(i), database.getAges(i));
      }
    }
  }

  public void createNewProfile(String userName, String age) {

    userName = userName.toLowerCase();
    userName = userName.replace(userName.charAt(0), Character.toUpperCase(userName.charAt(0)));

    database.setUserName(userName);
    database.setAge(age);

    boolean isInt = false;

    for (int i = 0; i < age.length(); i++) {
      if (Character.isDigit(database.getAge().charAt(i))) {
        isInt = true;
      }
    }

    if (database.alreadyContains(userName)) {

      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(database.getUserName());

    } else if (database.getUserName().length() < 3) {

      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(database.getUserName());

    } else if (isInt == true && Integer.valueOf(database.getAge()) >= 0) {

      database.addUserName();
      database.addAge();
      MessageCli.PROFILE_CREATED.printMessage(database.getUserName(), database.getAge());

    } else {
      MessageCli.INVALID_AGE.printMessage(database.getAge(), database.getUserName());
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
