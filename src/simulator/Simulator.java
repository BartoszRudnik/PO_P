package simulator;

import javax.swing.Timer;
import java.util.List;

/** Główna klasa symulacji
  * */
public class Simulator{
    /** Zmienna timer */
    private Timer timer;
    /** Zmienna budynek */
    private Building building;
    /** Zmienna kreowania pasażera*/
    private PassengerCreator passengerCreator;
    /** Zmienna kontrol */
    private ControlSystem control;
    /** zmienna opóźnienia symulacji */
    private int delay = 100;
    /** zmienna czasu symulacji */
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
            passengerCreator.AddingPassengers( addpassengers, time );
            control.ManageElevators(floors, elevators);
            MoveElevators();
            FloorLetPassengers();
            time++;
        });
    }

    /** Metoda zwracająca budynek */
    public Building getBuilding() {
        return building;
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
     * @param index
     */
    public String GetInformation(int index)
    {
        return building.GetElevator(index).information;
    }

    /** Metoda zwracająca piętro docelowe dla windy
     * @param index
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
     * @param index
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
        //TODO
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
