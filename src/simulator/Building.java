package simulator;
import java.util.ArrayList;
import java.util.List;

/** Publiczna klasa budynku
 * W budynku znajdują sie windy i piętra
 * Symbolizują je listy floorList (dla pieter) i elevatorList (dla wind)
 * */
public class Building{

    /** Lista pieter*/
    private List<Floor> floorList = new ArrayList <>();
    /** Lista wind*/
    private List<Elevator> elevatorList = new ArrayList <>();
    /** Maksymalna liczba pasazerow */
    private int MaxPassangerNumber = 8;

    /** Konstruktor klasy Building
     * Tworzy pietra i windy w budynku
     * @param numberOfFloors liczba pięter
     * @param numberOfElevators liczba wind
     * */
    Building( int numberOfFloors, int numberOfElevators)
    {
        // Dodawanie pięter do budynku
        for( int i = 0; i < numberOfFloors; i++){
            floorList.add(new Floor());
        }
        // Dodawanie wind do budynku
        for( int i = 0; i < numberOfElevators;i++){
            elevatorList.add(new Elevator(MaxPassangerNumber));
        }
    }

    /** Metoda zwracająca listę wind w postaci interfejsu Elevators
     * @return Lista wind w postaci interfejsow IElevator
     * */
    public List<IElevator> GetIElevators(){
        return new ArrayList<>(elevatorList);
    }

    /** Metoda zwracająca listę pięter w postaci interfejsu IFloor
     * @return Lista pieter w postaci interfejsow IFloor
     * */
    public List<IFloor> GetIFloors(){
        return new ArrayList<>(floorList);
    }

    /** Publiczna metoda zwracajaca miejsce z pasazerami do ich obslugi
     * @return Lista pieter
     * */
    public List<ASpace> GetIPassengerControl(){
        return new ArrayList<>(floorList);
    }

    /** Metoda zwracająca numer piętra
     * @param i indeks
     * @return Pietro
     */
    public Floor GetFloor(int i){
        return floorList.get(i);
    }

    /** Metoda zwracająca numer windy
     * @param i indeks
     * @return Winda
     */
    public Elevator GetElevator(int i){
        return elevatorList.get(i);
    }

    /** Metoda zwracająca liczbe pieter w budynku
     * @return Liczba pieter
     * */
    public int GetNumberOfFloors(){
        return floorList.size();
    }

    /** Metoda zwracająca liczbe wind w budynku
     * @return Liczbę wind
     * */
    public int GetNumberOfElevators(){
        return elevatorList.size();
    }
}