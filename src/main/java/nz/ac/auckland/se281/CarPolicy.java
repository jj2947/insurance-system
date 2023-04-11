package nz.ac.auckland.se281;

public class CarPolicy extends Policy{

    private String makeAndModel;
    private String licensePlate;
    private boolean mechanicalBreakdown;

    public CarPolicy(String[] options) {
        super(options);

        makeAndModel = options[1];
        licensePlate = options[2];

        if (options[3].equals("yes")) {
        mechanicalBreakdown = true;
        } else {
            mechanicalBreakdown = false;
        }

    }

    
    
}
