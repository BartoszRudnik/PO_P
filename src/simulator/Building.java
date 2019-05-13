package simulator;
import java.util.ArrayList;
import java.util.List;

/** Publiczna klasa budynku*/
public class Building implements IManageElevators{

    /** Lista pięter*/
    List<Floor> floorList = new ArrayList <>();
    /** Lista wind*/
    List<Elevator> elevatorList = new ArrayList <>();

    /** Konstruktor klasy Building*/
    Building( int numberOfFloors, int numberOfElevators){
        // Dodawanie pięter do budynku
        for( int i = 0; i < numberOfFloors)
        {
            floorList.add(new Floor());
        }
        // Dodawanie wind do budynku
        for( int i = 0; i < numberOfElevators)
        {
            elevatorList.add(new Elevator());
        }
    }

    /** Metoda zwracająca liczbę pięter*/
    public int GetNumberOfFloors(){
        return floorList.size();
    }

    /** Metoda zwracająca liczbę wind*/
    public int GetNumberOfElevators(){
        return elevatorList.size();
    }

    @Override
    public void ManageElevators(){
        //TO DO
    }

    @Override
    private int CheckOnWhichFloorTheMostPassangers(){
        //TO DO
    }

    @Override
    private void CheckTheNumberOfElevatorPassangers() {
        //TO DO
    }

    @Override
    private void GiveTheNewTargetElevator(Elevator){
        //TO DO
    }

}
