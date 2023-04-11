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
        basePremium = (2/100)*sumInusred;
    } else {
        basePremium = (1/100)*sumInusred;
    }

    return basePremium;
  }
}
