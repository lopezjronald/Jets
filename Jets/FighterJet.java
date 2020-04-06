package Jets;

public class FighterJet extends Jets implements FightingJetSpecialties {
    public FighterJet(String model, double speed, int range, long price) {
        super(model, speed, range, price);
    }

    @Override
    public void fight() {
        System.out.println(getModel() + " is fighting with the enemy.");
    }

    @Override
    public void groundAttack() {
        System.out.println("Performing ground attack.");
    }

    @Override
    public void launchMissile() {
        System.out.println("Launching a missile.");
    }

    @Override
    public void airAttack() {
        System.out.println("Performing an air attack.");
    }
}
