package Jets;

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Scanner;

	public class JetsApplication {
	    public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);
	        Airfield airField = new Airfield();
	        CargoPlane cargoPlane;
	        VanillaJetImpl vanillaJet;
	        FighterJet fighterJet;
	        String input;

	        //Reading the text file and comparing it with the first index number to place it in the correct object
	        try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
	            String line;
	            while ((line = bufIn.readLine()) != null) {
	                String[] plane = line.split(",");
	                if (plane[0].equalsIgnoreCase("cargojet")){
	                    cargoPlane = new CargoPlane((plane[1]), Double.parseDouble(plane[2]), Integer.parseInt(plane[3]), Long.parseLong(plane[4]));
	                    airField.getJetsArrayList().add(cargoPlane);
	                } else if (plane[0].equalsIgnoreCase("fighterjet")) {
	                    fighterJet = new FighterJet((plane[1]), Double.parseDouble(plane[2]), Integer.parseInt(plane[3]), Long.parseLong(plane[4]));
	                    airField.getJetsArrayList().add(fighterJet);
	                } else if (plane[0].equalsIgnoreCase("vanillajet")){
	                    vanillaJet = new VanillaJetImpl((plane[1]), Double.parseDouble(plane[2]), Integer.parseInt(plane[3]), Long.parseLong(plane[4]));
	                    airField.getJetsArrayList().add(vanillaJet);
	                }
	            }
	        }
	        catch (IOException e) {
	            System.err.println(e);
	        }

	        while (true) {
	            airField.displayMenu();
	            input = scanner.nextLine();
	            airField.action(input, airField);
	        }
	    }

	}
