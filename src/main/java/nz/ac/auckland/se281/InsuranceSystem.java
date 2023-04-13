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

      // Database with one profile
    } else if (database.size() == 1) {

      // Prints how many profiles the database has
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", ":", "");

      // Profile that isn't loaded
      if (database.get(0).getLoadStatus() == false) {

        // Prints details for a profile with 1 policy
        if (database.get(0).getNumPolicies() == 1) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "",
              "1",
              database.get(0).getUserName(),
              database.get(0).getAge(),
              String.valueOf(database.get(0).getNumPolicies()),
              "y",
              String.valueOf(database.get(0).getTotalPrice()));
          // Prints the policies of the profile
          database.get(0).printPolicies();

          // Prints details for a profile with 0 or more than 1 policies
        } else {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "",
              "1",
              database.get(0).getUserName(),
              database.get(0).getAge(),
              String.valueOf(database.get(0).getNumPolicies()),
              "ies",
              String.valueOf(database.get(0).getTotalPrice()));

          // Prints policies of the profile
          database.get(0).printPolicies();
        }

        // Profile that is loaded
      } else {

        // Prints details for a profile with 1 policy
        if (database.get(0).getNumPolicies() == 1) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ",
              "1",
              database.get(0).getUserName(),
              database.get(0).getAge(),
              "1",
              "y",
              String.valueOf(database.get(0).getTotalPrice()));
          // Prints the policies of the profile
          database.get(0).printPolicies();

          // Prints details for a profile with 0 or more than 1 policies
        } else {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ",
              "1",
              database.get(0).getUserName(),
              database.get(0).getAge(),
              String.valueOf(database.get(0).getNumPolicies()),
              "ies",
              String.valueOf(database.get(0).getTotalPrice()));
          // Prints the policies of the profile
          database.get(0).printPolicies();
        }
      }

      // Database with 3 or more profiles
    } else {

      // Prints how many profiles there are in the databse
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(database.size()), "s", ":");

      // Loops through the database arraylist to get all the profiles in the database arraylist
      for (int i = 0; i < database.size(); i++) {

        // Profile that is loaded
        if (database.get(i).getLoadStatus() == true) {

          // Prints the details for a profile with 1 policy
          if (database.get(i).getNumPolicies() == 1) {
            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
                "*** ",
                String.valueOf(i + 1),
                database.get(i).getUserName(),
                database.get(i).getAge(),
                String.valueOf(database.get(i).getNumPolicies()),
                "y",
                String.valueOf(database.get(i).getTotalPrice()));
            // Prints the policies of the profile
            database.get(i).printPolicies();

            // Prints details for a profile with 0 or more than 1 policies
          } else {
            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
                "*** ",
                String.valueOf(i + 1),
                database.get(i).getUserName(),
                database.get(i).getAge(),
                String.valueOf(database.get(i).getNumPolicies()),
                "ies",
                String.valueOf(database.get(i).getTotalPrice()));
            // Prints the policies of the profile
            database.get(i).printPolicies();
          }

          // Profile that isn't loaded
        } else {

          // Prints the details for a profile with 1 policy
          if (database.get(i).getNumPolicies() == 1) {
            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
                "",
                String.valueOf(i + 1),
                database.get(i).getUserName(),
                database.get(i).getAge(),
                String.valueOf(database.get(i).getNumPolicies()),
                "y",
                String.valueOf(database.get(i).getTotalPrice()));
            // Prints the policies of the profile
            database.get(i).printPolicies();

            // Prints details for a profile with 0 or more than 1 policies
          } else {
            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
                "",
                String.valueOf(i + 1),
                database.get(i).getUserName(),
                database.get(i).getAge(),
                String.valueOf(database.get(i).getNumPolicies()),
                "ies",
                String.valueOf(database.get(i).getTotalPrice()));
            // Prints the policies of the profile
            database.get(i).printPolicies();
          }
        }
      }
    }
  }

  // Implements the CREATE_PROFILE command
  public void createNewProfile(String userName, String age) {

    // Declares variables
    boolean alreadyContains = false;
    boolean isInt = false;
    Profile loadedProfile = null;

    // Makes sure the inputted username is in title case
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

      // If there is a loaded profile in the database arrayList, it is assigned to loadedProfile
      if (database.get(i).getLoadStatus() == true) {
        loadedProfile = database.get(i);
      }
    }

    // Makes a new instance of a profile
    Profile newProfile = new Profile(userName, age, false);

    // Prints message for when a profile is already loaded
    if (loadedProfile != null) {

      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(loadedProfile.getUserName());

      // Prints message for when the database already contains the username
    } else if (alreadyContains) {

      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(newProfile.getUserName());

      // Prints message for a username that is too short
    } else if (newProfile.getUserName().length() < 3) {

      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(newProfile.getUserName());

      // Prints message for an invalid age
    } else if (!isInt || Integer.parseInt(newProfile.getAge()) < 0) {

      MessageCli.INVALID_AGE.printMessage(newProfile.getAge(), newProfile.getUserName());

      /* Prints message for when a profile is created successfully and adds the profile
      instance to the database arraylist*/
    } else {
      database.add(newProfile);
      MessageCli.PROFILE_CREATED.printMessage(newProfile.getUserName(), newProfile.getAge());
    }
  }

  // Implements the LOAD_PROFILE command
  public void loadProfile(String userName) {

    // Makes sure the inputted username is in title case
    userName = userName.toLowerCase();
    userName = userName.replace(userName.charAt(0), Character.toUpperCase(userName.charAt(0)));

    // If there are no profiles in the database, a profile cannot be loaded
    if (database.size() == 0) {
      MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);
      return;
    }

    // Prints the success or failure messages for loading a profile
    for (int i = 0; i < database.size(); i++) {

      // If a profile is in the database, it will be successfully loaded and a success message will
      // be printed, if there is an already loaded profile that profile will be unloaded
      if (userName.equals(database.get(i).getUserName())) {
        unloadProfile();
        database.get(i).setLoadStatus(true);
        MessageCli.PROFILE_LOADED.printMessage(userName);
        break;

        // If a profile can't be found in the database, it won't be successfully loaded and the
        // failure message will be printed
      } else if (i == database.size() - 1) {
        MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);
      }
    }
  }

  // Implements the UNLOAD_PROFILE command
  public void unloadProfile() {

    // Checks if there is a profile that is currently loaded and prints the unload message if there
    // is
    for (Profile profile : database) {
      if (profile.getLoadStatus() == true) {
        MessageCli.PROFILE_UNLOADED.printMessage(profile.getUserName());
        profile.setLoadStatus(false);
        return;
      }
    }

    // If there is not loaded profile, then the no profile loaded message is printed
    MessageCli.NO_PROFILE_LOADED.printMessage();
  }

  // Implements the DELETE_PROFILE command
  public void deleteProfile(String userName) {

    // Makes sure the username is in title case
    userName = userName.toLowerCase();
    userName = userName.replace(userName.charAt(0), Character.toUpperCase(userName.charAt(0)));

    // Checks to see if the username is in the profiles database
    for (Profile profile : database) {
      if (userName.equals(profile.getUserName())) {

        // Cannot delete profile when loaded
        if (profile.getLoadStatus() == true) {

          MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(userName);
          return;

          // If the profile is not loaded and is in the database, it is deleted
        } else {

          MessageCli.PROFILE_DELETED.printMessage(userName);
          database.remove(profile);
          return;
        }
      }
    }
    // If the profile is not in the database, the no profile to delete message is printed
    MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
  }

  // Implements the commands to create a policy
  public void createPolicy(PolicyType type, String[] options) {

    // Declares and initialises variable
    int age = 0;
    String userName = null;
    Profile loadedProfile = null;

    // Gets every profile in the databse
    for (Profile profile : database) {

      // If there is a laoded profile, it's parameters are set to variable
      if (profile.getLoadStatus() == true) {
        age = Integer.parseInt(profile.getAge());
        userName = profile.getUserName();
        loadedProfile = profile;
        break;

        // If there is no loaded profile, the failure message is pritned
      } else if (profile == database.get(database.size() - 1)) {
        MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();
        return;
      }
    }

    switch (type) {

        // User wants to create a Home policy
      case HOME:

        // A new home policy is added to the loaded profile
        HomePolicy homePolicy = new HomePolicy(options);
        loadedProfile.getPolicies().add(homePolicy);
        MessageCli.NEW_POLICY_CREATED.printMessage(
            homePolicy.getPolicyType().toString().toLowerCase(), loadedProfile.getUserName());
        break;

        // User wants to create a life policy
      case LIFE:

        // Checks to see if the loaded profile already has a life policy and prints the failure
        // message as profile can't have more than one life policy
        for (Policy policy : loadedProfile.getPolicies()) {
          if (policy.getPolicyType() == PolicyType.LIFE) {
            MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(userName);
            return;
          }
        }

        // Checks to see if the loaded profile has an age above 100 and prints the over age limit
        // message
        if (age > 100) {
          MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(userName);
          return;
        }

        // If all the conditions to create a new life policy are met, a new policy is created for
        // the loaded profile and the new policy created message is printed
        LifePolicy lifePolicy = new LifePolicy(options, age);
        loadedProfile.getPolicies().add(lifePolicy);
        MessageCli.NEW_POLICY_CREATED.printMessage(
            lifePolicy.getPolicyType().toString().toLowerCase(), loadedProfile.getUserName());
        break;

        // User wants to create a car policy
      case CAR:

        // A new car policy is added to the loaded profile
        CarPolicy carPolicy = new CarPolicy(options, age);
        loadedProfile.getPolicies().add(carPolicy);
        MessageCli.NEW_POLICY_CREATED.printMessage(
            carPolicy.getPolicyType().toString().toLowerCase(), loadedProfile.getUserName());
        break;
    }
  }
}
