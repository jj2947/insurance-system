package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

// LifePolicy class
public class LifePolicy extends Policy {

  private int age;

  // Constructor
  public LifePolicy(String[] options, int age) {
    super(PolicyType.LIFE, options);
    this.age = age;
  }

  // Implements the abstract method getBasePremium
  @Override
  public int getBasePremium() {
    float Age = (float) (age);
    float basePremium = ((1 + Age / 100) / 100) * sumInusred;
    int premium = (int) (basePremium);
    return premium;
  }
}
