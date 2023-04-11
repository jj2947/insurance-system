package nz.ac.auckland.se281;

public abstract class Policy {
    
    protected int sumInusred;
    
    public Policy(String[] options) {
        this.sumInusred = Integer.parseInt(options[0]);
    }

    public int getSumInsured() {
        return sumInusred;
    }

    public abstract int getBasePremium();
}
