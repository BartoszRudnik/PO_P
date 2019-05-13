package simulator;
import java.util.ArrayList;
import java.util.List;

/** Publiczna klasa budynku*/
public class Building implements IManageElevators{

    /** Lista pięter*/
    private List<Floor> floorList = new ArrayList <>();
    /** Lista wind*/
    private List<Elevator> elevatorList = new ArrayList <>();

    public int usunto;
    /** Konstruktor klasy Building*/
    Building( int numberOfFloors, int numberOfElevators){
        // Dodawanie pięter do budynku
        for( int i = 0; i < numberOfFloors; i++)
        {
            floorList.add(new Floor());
        }
        // Dodawanie wind do budynku
        for( int i = 0; i < numberOfElevators; i++)
        {
            elevatorList.add(new Elevator(usunto));
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
    public int CheckOnWhichFloorTheMostPassangers(){
        //TO DO
        return 0;
    }

    @Override
    public void CheckTheNumberOfElevatorPassangers() {
        //TO DO
    }

    @Override
    public void GiveTheNewTargetElevator(Elevator elevator){
        //TO DO
    }

}
