package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

// HomePolicy class
public class HomePolicy extends Policy {

  private String address;
  private boolean rental;

  // Constructor
  public HomePolicy(String[] options) {
    super(PolicyType.HOME, options);
    address = options[1];

    // Sets the rental variable from options array
    if (options[2].equals("yes")) {
      rental = true;
    } else {
      rental = false;
    }
  }

  // Returns address of a policy instance
  public String getAddress() {
    return address;
  }

  // Implements the abstract method getBasePremium
  @Override
  public int getBasePremium() {

    int basePremium;

    // If the home is rented out, then the base premium is 2% of the sum insured.
    // If the home is not rented out, then the base premium is 1% of the sum insured.
    if (rental) {
      basePremium = (int) (0.02 * sumInusred);
    } else {
      basePremium = (int) (0.01 * sumInusred);
    }

    return basePremium;
  }
}
