package Jets;

public class CargoPlane extends Jets implements CargoJetSpecialties {
    public CargoPlane(String model, double speed, int range, long price) {
        super(model, speed, range, price);
    }

    @Override
    public void loadCargo() {
        System.out.println(getModel() + " loading cargo into plane.");
    }

    @Override
    public void distributeCargo() {
        System.out.println("Distributing cargo in the plane.");
    }

    @Override
    public void directGroundCrew() {
        System.out.println("Directing ground crew in the loading, unloading, securing, and staging of aircraft cargo.");
    }

    @Override
    public void accompanyAircraft() {

    }
}
