package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

// Profile class which creates instances of a profile
public class Profile {

  // Declares variables
  private String userName;
  private String age;
  private boolean loadStatus;

  // Creates an ArrayList of Policy objects that will store the policies a profile has
  private ArrayList<Policy> policies = new ArrayList<>();

  // Constructor
  public Profile(String userName, String age, boolean loadStatus) {
    this.userName = userName;
    this.age = age;
    this.loadStatus = loadStatus;
  }

  // Gets the username of a profile instance
  public String getUserName() {
    return this.userName;
  }

  // Gets the age of a profile instance
  public String getAge() {
    return this.age;
  }

  // Returns whether or not a profile is loaded
  public boolean getLoadStatus() {
    return this.loadStatus;
  }

  // Loads or unloads a profile
  public void setLoadStatus(boolean loadStatus) {
    this.loadStatus = loadStatus;
  }

  // Returns the number of policies in a profile
  public int getNumPolicies() {
    return policies.size();
  }

  // Adds a policy to a profile
  public void addPolicy(Policy policy) {
    policies.add(policy);
  }

  // Returns the policies of a profile
  public ArrayList<Policy> getPolicies() {
    return policies;
  }

  // Returns the total price for the policies of a profile
  public int getTotalPrice() {
    int total = 0;

    // Loops through the policies ArrayList and adds the discounted premium of each policy to the
    // total price
    for (Policy policy : policies) {
      total += policy.getDiscountedPremium(policies.size());
    }
    return total;
  }

  // Prints all the policies of a profile
  public void printPolicies() {

    // Loops through the policies ArrayList, which contains all the policies a profile has
    for (Policy policy : policies) {

      // Car policy
      if (policy.getPolicyType() == PolicyType.CAR) {

        // Casts the policy to a CarPolicy object
        CarPolicy carPolicy = (CarPolicy) policy;

        // Prints the details of the car policy
        MessageCli.PRINT_DB_CAR_POLICY.printMessage(
            carPolicy.getMakeAndModel(),
            String.valueOf(carPolicy.getSumInsured()),
            String.valueOf(carPolicy.getBasePremium()),
            String.valueOf(carPolicy.getDiscountedPremium(getNumPolicies())));

        // Home policy
      } else if (policy.getPolicyType() == PolicyType.HOME) {

        // Casts the policy to a HomePolicy object
        HomePolicy homePolicy = (HomePolicy) policy;

        // Prints the details of the home policy
        MessageCli.PRINT_DB_HOME_POLICY.printMessage(
            homePolicy.getAddress(),
            String.valueOf(homePolicy.getSumInsured()),
            String.valueOf(homePolicy.getBasePremium()),
            String.valueOf(homePolicy.getDiscountedPremium(getNumPolicies())));

        // Life policy
      } else {

        // Casts the policy to a LifePolicy object
        LifePolicy lifePolicy = (LifePolicy) policy;

        // Prints the details of the life policy
        MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
            String.valueOf(lifePolicy.getSumInsured()),
            String.valueOf(lifePolicy.getBasePremium()),
            String.valueOf(lifePolicy.getDiscountedPremium(getNumPolicies())));
      }
    }
  }
}
