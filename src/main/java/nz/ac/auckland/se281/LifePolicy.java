package nz.ac.auckland.se281;
import nz.ac.auckland.se281.Main.PolicyType;

public class LifePolicy extends Policy {

  private int age;

  public LifePolicy(String[] options, int age) {
    super(PolicyType.LIFE, options);
    this.age = age;
  }

  @Override
  public int getBasePremium() {
    float Age = (float)(age);
    float basePremium = ((1+Age/100))*sumInusred;
    int premium = (int) (basePremium);
    return premium;
  }
}
