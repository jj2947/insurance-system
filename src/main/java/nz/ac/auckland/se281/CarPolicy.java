package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

// CarPolicy class
public class CarPolicy extends Policy {

  private String makeAndModel;
  private boolean mechanicalBreakdown;
  private int age;
  private int basePremium;

  // Constructor
  public CarPolicy(String[] options, int age) {
    super(PolicyType.CAR, options);

    // Gets make and model from options array
    makeAndModel = options[1];
    this.age = age;

    // Gets the mechanical breakdown information from options array
    if (options[3].equals("yes")) {
      mechanicalBreakdown = true;
    } else {
      mechanicalBreakdown = false;
    }
  }

  // Gets make and model for a policy instance
  public String getMakeAndModel() {
    return makeAndModel;
  }

  // Implements the abstract method getBasePremium
  @Override
  // If the client is under 25 years old, then the base premium is 15% of the sum insured.
  // If the client is 25 years old or older, then the base premium is 10% of the sum insured.
  public int getBasePremium() {
    if (age < 25) {
      basePremium = (int) (0.15 * sumInusred);
    } else {
      basePremium = (int) (0.10 * sumInusred);
    }

    // If the car is to be covered for mechanical breakdown, then the base premium is increased by a
    // further $80 (regardless of age)
    if (mechanicalBreakdown) {
      basePremium += 80;
    }

    return basePremium;
  }
}
