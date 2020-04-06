package Jets;

import java.util.ArrayList;
import java.util.Scanner;

public class Airfield {

    private ArrayList <Jets> jetsArrayList = new ArrayList <>();
    Scanner scanner = new Scanner (System.in);

    public Airfield() {
    }

    public void displayMenu(){
        System.out.println("\nPlease choose from the following menu:");
        System.out.println("1. List Fleet");
        System.out.println("2. Fly all jets");
        System.out.println("3. View fastest jet");
        System.out.println("4. View jet with longest range");
        System.out.println("5. Load all Cargo Jets");
        System.out.println("6. Dogfight");
        System.out.println("7. Add a jet to Fleet");
        System.out.println("8. Remove a jet from Fleet");
        System.out.println("9. Quit");
    }

    public void action(String input, Airfield airField){
        {
            switch (input) {

                case "1":
                    airField.displayFleet(airField);
                    break;

                case "2":
                    for (Jets eachJet : airField.getJetsArrayList())
                        eachJet.fly();
                    break;

                case "3":
                    airField.fastestJet(airField);
                    break;

                case "4":
                    airField.longestRange(airField);
                    break;

                case "5":
                    for (Jets eachJet : airField.getJetsArrayList()){
                        CargoPlane cargoPlaneLoaders;
                        if (eachJet.getClass().getSimpleName().equalsIgnoreCase("cargoplane")){
                            cargoPlaneLoaders = new CargoPlane (eachJet.getModel(), eachJet.getSpeed(), eachJet.getRange(), eachJet.getPrice());
                            cargoPlaneLoaders.loadCargo();
                        }
                    }
                    break;

                case "6":
                    for (Jets eachJet : airField.getJetsArrayList()){
                        FighterJet fighterJet;
                        if (eachJet.getClass().getSimpleName().equalsIgnoreCase("fighterjet")){
                            fighterJet = new FighterJet (eachJet.getModel(), eachJet.getSpeed(), eachJet.getRange(), eachJet.getPrice());
                            fighterJet.fight();
                        }
                    }
                    break;

                case "7":
                    airField.addToFleet(airField);
                    break;

                case "8":
                    airField.removeFromFleet(airField);
                    break;

                case "9":
                    System.out.println("Have a great day!");
                    scanner.close();
                    System.exit(0);
            }
        }
    }

    public void fastestJet(Airfield airField){
        double fastestJet = -1;
        String fastestJetInfo = null;
        for (Jets eachJet : airField.getJetsArrayList()){
            if (fastestJetInfo == null) {
                fastestJet = eachJet.getSpeed();
                fastestJetInfo = eachJet.dataToFile();
            } else if (eachJet.getSpeed() > fastestJet) {
                fastestJet = eachJet.getSpeed();
                fastestJetInfo = eachJet.dataToFile();
            }
        }
        System.out.println("The fast jet is the following:\n" + fastestJetInfo);
    }

    public void longestRange(Airfield airField){
        int longestRange = -1;
        String jetWithLongestRange = null;
        for (Jets eachJet : airField.getJetsArrayList()){
            if (jetWithLongestRange == null) {
                longestRange = eachJet.getRange();
                jetWithLongestRange = eachJet.dataToFile();
            } else if (eachJet.getRange() > longestRange) {
                longestRange = eachJet.getRange();
                jetWithLongestRange = eachJet.dataToFile();
            }
        }
        System.out.println("The jet with the longest range is the following:\n" + jetWithLongestRange);
    }

    public void removeFromFleet(Airfield airField){
        int count = 1, index;
        String choice;

        System.out.println("Please choose the jet you would like to remove by pressing its designated number: ");

        for (Jets eachJet : airField.getJetsArrayList()){
            System.out.println(count + ". " + eachJet.getModel());
            count++;
        }

        while (true) {
            choice = scanner.nextLine();

            try {
                index = Integer.parseInt(choice);
            } catch (Exception e){
                System.out.println("You have entered an invalid choice.");
                System.out.println("Please choose the jet you would like to remove: ");
                continue;
            }

            try {
                airField.getJetsArrayList().remove(index-1);
                break;
            } catch (Exception e) {
                System.out.println("Sorry, you have entered an invalid choice. \"Please choose the jet you would like to remove:");
            }
        }
    }

    public void addToFleet(Airfield airField){
        String jetType, model, priceString, speedString, rangeString;
        double speed;
        int range;
        long price;

        while (true) {
            System.out.println("Please press the correct type of jet entering the airfield:");
            System.out.println("1. Fighter Jet");
            System.out.println("2. Cargo Jet");
            System.out.println("3. Vanilla Style Jet");
            jetType = scanner.nextLine();

            if (jetType.equals("1") || jetType.equals("2") || jetType.equals("3"))
                break;
            else {
                System.out.println("Sorry, you have entered an invalid choice. Please choose from 1 to 3:");
                continue;
            }
        }

        System.out.println("Please enter the model: ");
        model = scanner.nextLine();

        while (true) {
            System.out.println("Please enter the speed: ");
            speedString = scanner.nextLine();
            try {
                speed = Double.parseDouble(speedString);
                break;
            } catch (Exception e) {
                System.out.println("You have entered an invalid entry.");
            }
        }

        while (true) {
            System.out.println("Please enter the range: ");
            rangeString = scanner.nextLine();
            try {
                range = Integer.parseInt(rangeString);
                break;
            } catch (Exception e) {
                System.out.println("You have entered an invalid entry.");
            }
        }

        while (true) {
            System.out.println("Please enter the price: ");
            priceString = scanner.nextLine();
            try {
                price = Long.parseLong(priceString);
                break;
            } catch (Exception e) {
                System.out.println("You have entered an invalid entry.");
            }
        }

        switch (jetType){
            case "1":
                Jets newFighterJet = new FighterJet(model, speed, range, price);
                airField.getJetsArrayList().add(newFighterJet);
                break;
            case "2":
                Jets newCargoJet = new CargoPlane(model, speed, range, price);
                airField.getJetsArrayList().add(newCargoJet);
                break;
            case "3":
                Jets newVanillaJet = new VanillaJetImpl(model, speed, range, price);
                airField.getJetsArrayList().add(newVanillaJet);
                break;
            default:
                System.out.println("Sorry, you have entered an invalid entry.");
        }
    }

    public void displayFleet(Airfield airField){
        System.out.println("All Jets on Airfield");
        System.out.println();

        System.out.println("Cargo Jets");
        for (Jets cargoJet : airField.getJetsArrayList()){
            if (cargoJet.getClass().getSimpleName().equalsIgnoreCase("cargoplane")){
                System.out.println(cargoJet);
            }
        }

        System.out.println("\nFighter Jets");
        for (Jets cargoJet : airField.getJetsArrayList()){
            if (cargoJet.getClass().getSimpleName().equalsIgnoreCase("fighterjet")){
                System.out.println(cargoJet);
            }
        }

        System.out.println("\nVanilla Jets");
        for (Jets cargoJet : airField.getJetsArrayList()){
            if (cargoJet.getClass().getSimpleName().equalsIgnoreCase("vanillajetimpl")){
                System.out.println(cargoJet);
            }
        }
    }

    @Override
    public String toString() {
        return "AirField{" +
                "jetsArrayList=" + jetsArrayList +
                '}';
    }

    public ArrayList<Jets> getJetsArrayList() {
        return jetsArrayList;
    }

}
