package simulator;
import java.util.ArrayList;
import java.util.List;

/** Publiczna klasa budynku*/
public class Building{

    /** Lista pięter*/
    private List<Floor> floorList = new ArrayList <>();
    /** Lista wind*/
    private List<Elevator> elevatorList = new ArrayList <>();
    /** Maksymalna liczba pasazerow */
    private int MaxPassangerNumber = 8;

    /** Konstruktor klasy Building*/
    Building( int numberOfFloors, int numberOfElevators)
    {
        /** Dodawanie pięter do budynku */
        for( int i = 0; i < numberOfFloors;i++)
        {
            floorList.add(new Floor());
        }
        /** Dodawanie wind do budynku */
        for( int i = 0; i < numberOfElevators;i++)
        {
            elevatorList.add(new Elevator(MaxPassangerNumber));
        }
    }

    /** Metoda zwracająca daną windę*/
    public Elevator GetElevator(int index){
        return elevatorList.get(index);
    }

    /** Metoda zwracająca dane piętro*/
    public Floor GetFloor(int index){
        return floorList.get(index);
    }

    /** Metoda zwracająca liczbę pięter w bdynku*/
    public int GetNumberOfFloors(){
        return floorList.size();
    }

    /** Metoda zwracająca liczbę wind w budynku*/
    public int GetNumberOfElevators(){
        return elevatorList.size();
    }
}