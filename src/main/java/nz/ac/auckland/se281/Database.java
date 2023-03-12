package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Database {

    // Creates the arraylist that will store all the user profiles
    private ArrayList<String> profiles = new ArrayList<String>();

    private String userName;
    private String age;

    public Database() {
    }

    public Database(String userName, String age) {
        this.userName = userName;
        this.age = age;
    }

    public void addProfile() {
        profiles.add(this.userName + this.age);
    }

    public void printDB() {
        if (profiles.size() == 0) {
            MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
        } else if (profiles.size() == 1) {
            MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", ":");
        } else {
            MessageCli.PRINT_DB_POLICY_COUNT.printMessage(String.valueOf(profiles.size()), "s", ":");
        }
    }

}
