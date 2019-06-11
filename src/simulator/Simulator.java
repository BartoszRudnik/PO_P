package simulator;

import javax.swing.Timer;
import java.util.List;

/** Klasa symulacji
  * */
public class Simulator{
    /** Pole timer */
    private Timer timer;
    /** Pole budynek */
    private Building building;
    /** Pole kreowania pasażera*/
    private PassengerCreator passengerCreator;
    /** Pole kontrol */
    private IManageElevators control;
    /** Pole opóźnienia symulacji */
    private int delay = 500;
    /** Pole czasu symulacji */
    private int time = 0;

    /** Utworzenie Listy pięter, wind i dodawania pasażerów */
    private List<IFloor> floors;
    private List<IElevator> elevators;
    private List<ASpace> addpassengers;

    /** Konstruktor klasy Sumulator
     * @param numberOfFloors liczba pięter
     * @param numberOfElevators liczba wind
     */
    Simulator(int numberOfFloors, int numberOfElevators){
        building = new Building( numberOfFloors, numberOfElevators);
        floors = building.GetIFloors();
        elevators = building.GetIElevators();
        addpassengers = building.GetIPassengerControl();
        passengerCreator = new PassengerCreator(numberOfFloors);
        control = new ControlSystem();
        timer = new Timer(delay, e -> {
            if(!passengerCreator.AddingPassengers( addpassengers, time )){
                int counter = 0;
                for( IElevator elevator : elevators){
                    if(elevator.GetNumberOfFreePlaces() == elevator.MaxNumberPassangers()){
                        counter++;
                    }
                }
                if(counter == elevators.size()){
                    timer.stop();
                    System.out.println("End");
                }
            }
            control.ManageElevators(floors, elevators);
            MoveElevators();
            FloorLetPassengers();
            time++;
        });
    }

    /** Metoda rozpoczynająca mierzenie czasu  */
    public void startTimer(){
        timer.start();
    }
    /** Metoda zatrzymująca mierzenie czasu */
    public void stopTimer(){
        timer.stop();
    }
    /** Metoda zwracająca czas  */
    public int getTime() {
        return time;
    }

    /** Metoda zwracająca liczbe pasażerów
     * @param index
     */
    public int GetNumberofPassanger(int index)
    {
        return  building.GetElevator(index).getNumberOfPassanger();
    }

    /** Metoda zwraca informacje o windzie
     * @param index indeks windy z której pobieramy informację
     */
    public String GetInformation(int index)
    {
        return building.GetElevator(index).information;
    }

    /** Metoda zwracająca piętro docelowe dla windy
     * @param index indeks windy z której pobieramy docelowe piętro
     */
    public int GetTargetFloorElevator(int index)
    {
        return building.GetElevator(index).GetTargetFloor();
    }

    /** Metoda zwracająca obecne piętro windy
     * @param index
     */
    public int GetCurrentFloorElevator(int index)
    {
        return building.GetElevator(index).GetCurrentFloor();
    }

    /** Metoda zwracajaca kolejke na pietrze
     *
     * @param index indeks piętra z któego pobieramy liczbę pasażerów
     */
    public int GetQueueLengthFloor(int index)
    {
        return building.GetFloor(index).GetQueueLength();
    }

    /** Metoda ruchu windy */
    private void MoveElevators() {
        for (int i = 0; i < building.GetNumberOfElevators(); i++) {
            elevators.get(i).Move();
        }
    }

    /** Metoda wypuszczająca pasażerów */
    private void FloorLetPassengers(){
        for (int i = 0; i < building.GetNumberOfFloors(); i++) {
            if(building.GetFloor(i).getCall()){
                for(int j = 0; j < building.GetNumberOfElevators(); j++){
                    if(building.GetElevator(j).GetCurrentFloor() == i){
                        building.GetFloor(i).LetPassengersOut(building.GetElevator(j));
                        break;
                    }
                }
            }
        }
    }
}
