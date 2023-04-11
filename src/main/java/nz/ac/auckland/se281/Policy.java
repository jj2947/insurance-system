package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public abstract class Policy {

  protected int sumInusred;
  protected PolicyType type;

  public Policy(PolicyType type, String[] options) {
    this.sumInusred = Integer.parseInt(options[0]);
    this.type = type;
  }

  public int getSumInsured() {
    return sumInusred;
  }

  public PolicyType getPolicyType() {
    return type;
  }

  public abstract int getBasePremium();
  
}
