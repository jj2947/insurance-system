package nz.ac.auckland.se281;
import nz.ac.auckland.se281.Main.PolicyType;

public class HomePolicy extends Policy {

  private String address;
  private boolean rental;

  public HomePolicy(String[] options) {
    super(PolicyType.HOME, options);
    address = options[1];

    if (options[2].equals("yes")) {
      rental = true;
    } else {
      rental = false;
    }
  }

  public String getAddress() {
    return address;
  }

  @Override
  public int getBasePremium() {

    int basePremium;

    if (rental) {
        basePremium = (int)(0.02*sumInusred);
    } else {
        basePremium = (int)(0.01*sumInusred);
    }

    return basePremium;
  }
}
