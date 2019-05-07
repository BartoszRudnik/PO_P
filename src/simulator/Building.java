package simulator;
import java.util.ArrayList;
import java.util.List;

/** Publiczna klasa budynku*/
public class Building implements IManageElevators{

    /** Konstruktor klasy Building*/
    Building( int numberOfFloors, int numberOfElevators){
        /** Lista pięter*/
        List<Floor> floorList = new ArrayList <>(numberOfFloors);
        /** Lista wind*/
        List<Elevator> elevatorList = new ArrayList <>(numberOfElevators);
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
