package nz.ac.auckland.se281;
import nz.ac.auckland.se281.Main.PolicyType;

public class LifePolicy extends Policy {

  private int age;

  public LifePolicy(String[] options, int age) {
    super(PolicyType.LIFE, options);
  }

  @Override
  public int getBasePremium() {
    return ((1 + age / 100) / 100) * sumInusred;
  }
}
