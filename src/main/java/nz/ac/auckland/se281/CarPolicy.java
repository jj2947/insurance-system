package nz.ac.auckland.se281;

public class CarPolicy extends Policy {

  private String makeAndModel;
  private String licensePlate;
  private boolean mechanicalBreakdown;
  private int age;
  private int basePremium;

  public CarPolicy(String[] options, String age) {
    super(options);

    makeAndModel = options[1];
    licensePlate = options[2];
    this.age = Integer.parseInt(age);

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
      basePremium = (15 / 100) * sumInusred;
    } else {
      basePremium = (10 / 100) * sumInusred;
    }

    if (mechanicalBreakdown) {
      basePremium += 80;
    }

    return basePremium;
  }
}
