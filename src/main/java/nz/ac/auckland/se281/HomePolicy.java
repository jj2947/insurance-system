package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  private String address;
  private boolean rental;

  public HomePolicy(String[] options) {
    super(options);
    address = options[1];

    if (options[2].equals("yes")) {
      rental = true;
    } else {
      rental = false;
    }
  }
}
