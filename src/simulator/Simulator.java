package simulator;

import javax.swing.Timer;
import java.util.List;

/** Klasa symulacji
  * */
public class Simulator{
    private Timer timer;
    private Building building;
    private PassengerCreator passengerCreator;
    private ControlSystem control;
    private int delay = 100;
    private int time = 0;

    List<IFloor> floors;
    List<IElevator> elevators;
    List<ASpace> addpassengers;

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

    public Building getBuilding() {
        return building;
    }

    public void startTimer(){
        timer.start();
    }

    public void stopTimer(){
        timer.stop();
    }

    public int getTime() {
        return time;
    }

    public int GetNumberofPassanger(int index)
    {
        return  building.GetElevator(index).getNumberOfPassanger();
    }

    private void MoveElevators() {
        for (int i = 0; i < building.GetNumberOfElevators(); i++) {
            elevators.get(i).Move();
        }
    }

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
