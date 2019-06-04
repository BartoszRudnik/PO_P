package simulator;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/* Klasa symulacji
  * */
public class Simulator{
    private Timer timer;
    private Building building;
    private PassengerCreator passengerCreator;
    private ControlSystem control;
    private int delay = 500;
    private int time = 0;

    List<IFloor> floors;
    List<IElevator> elevators;
    List<IPassengerControl> addpassengers;

    Simulator(int numberOfFloors, int numberOfElevators){
        building = new Building( numberOfFloors, numberOfElevators);
        floors = building.GetIFloors();
        elevators = building.GetIElevators();
        addpassengers = building.GetIPassengerControl();
        passengerCreator = new PassengerCreator(numberOfFloors);
        control = new ControlSystem();
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passengerCreator.AddingPassengers( addpassengers, time );
                control.ManageElevators(floors, elevators);
                MoveElevators();
                FloorLetPassengers();
                time++;
            }
        });
        startTimer();
    }

    public Building getBuilding() {
        return building;
    }

    public void startTimer(){
        timer.start();
    }

    public void stopTimer(){
        stopTimer();
    }

    public int getTime() {
        return time;
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
                    if(building.GetElevator(j).GetCurrentFloor() == i && building.GetElevator(j).showIsOpen()){
                        building.GetFloor(i).LetPassengersOut(building.GetElevator(j));
                        break;
                    }
                }
            }
        }
    }
}
