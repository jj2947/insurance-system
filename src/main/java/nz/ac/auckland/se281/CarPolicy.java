package nz.ac.auckland.se281;
import nz.ac.auckland.se281.Main.PolicyType;

public class CarPolicy extends Policy {

  private String makeAndModel;
  private boolean mechanicalBreakdown;
  private int age;
  private int basePremium;

  public CarPolicy(String[] options, int age) {
    super(PolicyType.CAR, options);

    makeAndModel = options[1];
    this.age = age;

    if (options[3].equals("yes")) {
      mechanicalBreakdown = true;
    } else {
      mechanicalBreakdown = false;
    }
  }

  public String getMakeAndModel() {
    return makeAndModel;
  }

  @Override
  public int getBasePremium() {
    if (age < 25) {
      basePremium = (int)(0.15 * sumInusred);
    } else {
      basePremium = (int)(0.10 * sumInusred);
    }

    if (mechanicalBreakdown) {
      basePremium += 80;
    }

    return basePremium;
  }
}
