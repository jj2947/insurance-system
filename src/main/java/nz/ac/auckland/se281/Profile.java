package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

// Profile class which creates instances of a profile
public class Profile {

  // Declares variables
  private String userName;
  private String age;
  private boolean loadStatus;
  private ArrayList<Policy> policies = new ArrayList<>();

  // Constructor which initialises userName and age vaariables
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

  public int getNumPolicies() {
    return policies.size();
  }

  public void addPolicy(Policy policy) {
    policies.add(policy);
  }

  public ArrayList<Policy> getPolicies() {
    return policies;
  }

  public int getDiscountedPremium() {

    int totalPremium = 0;

    if (getNumPolicies() == 2) {

      totalPremium = policies.get(0).getBasePremium() + policies.get(1).getBasePremium();
      totalPremium = (int) (totalPremium * 0.9);

    } else if (getNumPolicies() >= 3) {

      for (Policy policy : policies) {
        totalPremium += policy.getBasePremium();
      }
      totalPremium = (int) (totalPremium * 0.8);

    } else {
      for (Policy policy : policies) {
        totalPremium += policy.getBasePremium();
      }
    }
    return totalPremium;
  }

  public void printPolicies() {
    for (Policy policy : policies) {
      if (policy.getPolicyType() == PolicyType.CAR) {
        CarPolicy carPolicy = (CarPolicy) policy;
        MessageCli.PRINT_DB_CAR_POLICY.printMessage(
            carPolicy.getMakeAndModel(),
            String.valueOf(carPolicy.getSumInsured()),
            String.valueOf(carPolicy.getBasePremium()),
            String.valueOf(getDiscountedPremium()));
      } else if 
    }
  }
}
