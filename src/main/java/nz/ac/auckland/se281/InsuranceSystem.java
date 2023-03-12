package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

import java.util.ArrayList;

public class InsuranceSystem {

  // Creates the arraylist that will store all the user profiles
  private ArrayList<String> profiles = new ArrayList<String>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    if (profiles.size() == 0) {
      System.out.println("Database has 0 profiles.");
    }
  }

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.
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
