package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

// Abstract Policy class
public abstract class Policy {

  protected int sumInusred;
  protected PolicyType type;

  // Constructor
  public Policy(PolicyType type, String[] options) {
    this.sumInusred = Integer.parseInt(options[0]);
    this.type = type;
  }

  // Returns the sum insured of a policy instance
  public int getSumInsured() {
    return sumInusred;
  }

  // Returns the policy type of a policy instance
  public PolicyType getPolicyType() {
    return type;
  }

  // Returns the base premium of a policy instance
  public abstract int getBasePremium();

  // Returns the discounted premium of a policy instance
  public int getDiscountedPremium(int numPolicies) {

    int discountedPremium = getBasePremium();

    // If the profile has 2 policies, then the discounted premium is 10% less than the base premium.
    if (numPolicies == 2) {

      discountedPremium = (int) (discountedPremium * 0.9);

      // If the profile has 3 or more policies, then the discounted premium is 20% less than the
      // base
    } else if (numPolicies >= 3) {

      discountedPremium = (int) (discountedPremium * 0.8);
    }

    return discountedPremium;
  }
}
