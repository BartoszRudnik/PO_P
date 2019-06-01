package simulator;
import java.util.ArrayList;
import java.util.List;

/** Publiczna klasa budynku
 * W budynku znajdują się windy i piętra
 * Symbolizują je listy floorList (dla pięter) i elevatorList (dla wind)
 * */
public class Building{

    /** Lista pięter*/
    private List<Floor> floorList = new ArrayList <>();
    /** Lista wind*/
    private List<Elevator> elevatorList = new ArrayList <>();
    /** Maksymalna liczba pasazerow */
    private int MaxPassangerNumber = 8;

    /** Konstruktor klasy Building
     * Tworzy piętra i windy w budynku
     * @param numberOfFloors liczba pięter
     * @param numberOfElevators liczba wind
     * */
    Building( int numberOfFloors, int numberOfElevators)
    {
        // Dodawanie pięter do budynku
        for( int i = 0; i < numberOfFloors; i++){
            floorList.add(new Floor(i));
        }
        // Dodawanie wind do budynku
        for( int i = 0; i < numberOfElevators;i++){
            elevatorList.add(new Elevator(MaxPassangerNumber));
        }
    }

    /** Metoda zwracająca daną windę
     * @param index indeks windy
     * */
    public Elevator GetElevator(int index){
        return elevatorList.get(index);
    }

    /** Metoda zwracająca piętro o danym indeksie
     * @param index indeks pietra
     * */
    public Floor GetFloor(int index){
        return floorList.get(index);
    }

    /** Metoda zwracająca liczbę pięter w budynku*/
    public int GetNumberOfFloors(){
        return floorList.size();
    }

    /** Metoda zwracająca liczbę wind w budynku*/
    public int GetNumberOfElevators(){
        return elevatorList.size();
    }
}