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

      if (database.get(0).getLoadStatus() == false) {

        if (database.get(0).getNumPolicies() == 1) {
          MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
              "",
              "1",
              database.get(0).getUserName(),
              database.get(0).getAge(),
              String.valueOf(database.get(0).getNumPolicies()),
              "y");
          database.get(0).printPolicies();
        } else {
          MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
              "",
              "1",
              database.get(0).getUserName(),
              database.get(0).getAge(),
              String.valueOf(database.get(0).getNumPolicies()),
              "ies");
          database.get(0).printPolicies();
        }

      } else {
        if (database.get(0).getNumPolicies() == 1) {
          MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
              "*** ", "1", database.get(0).getUserName(), database.get(0).getAge(), "1", "y");
        } else {
          MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
              "*** ",
              "1",
              database.get(0).getUserName(),
              database.get(0).getAge(),
              String.valueOf(database.get(0).getNumPolicies()),
              "ies");
        }
      }

      // Prints the message for a database with 3 or more profiles
    } else {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(database.size()), "s", ":");

      // Loops through the database arraylist to get the usernames and ages
      for (int i = 0; i < database.size(); i++) {

        // If profile is loaded, print the *** infront of it
        if (database.get(i).getLoadStatus() == true) {
          if (database.get(i).getNumPolicies() == 1) {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "*** ",
                String.valueOf(i + 1),
                database.get(i).getUserName(),
                database.get(i).getAge(),
                String.valueOf(database.get(i).getNumPolicies()),
                "y");
            database.get(i).printPolicies();
          } else {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "*** ",
                String.valueOf(i + 1),
                database.get(i).getUserName(),
                database.get(i).getAge(),
                String.valueOf(database.get(i).getNumPolicies()),
                "ies");
            database.get(i).printPolicies();
          }
        } else {
          if (database.get(i).getNumPolicies() == 1) {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "",
                String.valueOf(i + 1),
                database.get(i).getUserName(),
                database.get(i).getAge(),
                String.valueOf(database.get(i).getNumPolicies()),
                "y");
            database.get(i).printPolicies();
          } else {
            MessageCli.PRINT_DB_PROFILE_HEADER_MEDIUM.printMessage(
                "",
                String.valueOf(i + 1),
                database.get(i).getUserName(),
                database.get(i).getAge(),
                String.valueOf(database.get(i).getNumPolicies()),
                "ies");
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

      if (database.get(i).getLoadStatus() == true) {
        loadedProfile = database.get(i);
      }
    }

    // Makes a new instance of a profile
    Profile newProfile = new Profile(userName, age, false);

    // Prints message for when a profile is already loaded
    if (loadedProfile != null) {

      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(loadedProfile.getUserName());

      // Prints the message for when the database already contains the username
    } else if (alreadyContains) {

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

  // Implements the LOAD_PROFILE command
  public void loadProfile(String userName) {

    // Makes sure the username is in title case
    userName = userName.toLowerCase();
    userName = userName.replace(userName.charAt(0), Character.toUpperCase(userName.charAt(0)));

    // Prints the success or failure messages for loading a profile
    for (int i = 0; i < database.size(); i++) {

      // If a profile is in the database, it will be successfully loaded and a success message will
      // be printedif there is an already loaded profile that profile will be unloaded
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

    // Declares loadedProfile as Profile type
    Profile loadedProfile = null;

    // Sets loadedProfile to a profile in hte database arraylistif that profile is currently loaded
    for (Profile profile : database) {
      if (profile.getLoadStatus() == true) {
        loadedProfile = profile;
      }
    }

    // If there is a loadedProfile in the databse arraylist, it is unloaded and the unloaded message
    // is printed
    if (loadedProfile != null) {
      MessageCli.PROFILE_UNLOADED.printMessage(loadedProfile.getUserName());
      loadedProfile.setLoadStatus(false);

      // If there is no loaded profile, then the no profile loaded message is printed
    } else {
      MessageCli.NO_PROFILE_LOADED.printMessage();
    }
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

      // If the profile is not in the database, the no profile to delete message is printed
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
    }
  }

  public void createPolicy(PolicyType type, String[] options) {

    int age = 0;
    String userName = null;
    Profile loadedProfile = null;

    for (Profile profile : database) {
      if (profile.getLoadStatus() == true) {
        age = Integer.parseInt(profile.getAge());
        userName = profile.getUserName();
        loadedProfile = profile;
        break;
      } else if (profile == database.get(database.size() - 1)) {
        MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();
        return;
      }
    }

    switch (type) {
      case HOME:
        HomePolicy homePolicy = new HomePolicy(options);
        loadedProfile.getPolicies().add(homePolicy);
        MessageCli.NEW_POLICY_CREATED.printMessage(
            homePolicy.getPolicyType().toString().toLowerCase(), loadedProfile.getUserName());
        break;

      case LIFE:
        for (Policy policy : loadedProfile.getPolicies()) {
          if (policy.getPolicyType() == PolicyType.LIFE) {
            MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(userName);
            return;
          }
        }
        if (age > 100) {
          MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(userName);
          return;
        }

        LifePolicy lifePolicy = new LifePolicy(options, age);
        loadedProfile.getPolicies().add(lifePolicy);
        MessageCli.NEW_POLICY_CREATED.printMessage(
            lifePolicy.getPolicyType().toString().toLowerCase(), loadedProfile.getUserName());
        break;

      case CAR:
        CarPolicy carPolicy = new CarPolicy(options, age);
        loadedProfile.getPolicies().add(carPolicy);
        MessageCli.NEW_POLICY_CREATED.printMessage(
            carPolicy.getPolicyType().toString().toLowerCase(), loadedProfile.getUserName());
        break;
    }
  }
}
