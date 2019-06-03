package simulator;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Klasa symulacji
 * Główna klasa pliku, zawiera funkcją main
  * */
public class Simulator{
    private Timer timer;
    private Building building;
    private PassengerCreator passengerCreator;
    private ControlSystem control;
    private int delay = 1000;
    private int time = 0;

    Simulator(int numberOfFloors, int numberOfElevators){
        building = new Building( numberOfFloors, numberOfElevators);
        passengerCreator = new PassengerCreator(numberOfFloors);
        control = new ControlSystem();
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passengerCreator.AddingPassengers( building, time );
                control.ManageElevators(building);
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
            building.GetElevator(i).Move();
        }
    }

    private void FloorLetPassengers(){
        for (int i = 0; i < building.GetNumberOfFloors(); i++) {
            if(building.GetFloor(i).getCall()){
                for(int j = 0; j < building.GetNumberOfElevators(); j++){
                    if(building.GetElevator(j).GetCurrentFloor() == i && building.GetElevator(j).showIsOpen()){
                        building.GetFloor(i).LetPassengerOut(building.GetElevator(j));
                        break;
                    }
                }
            }
        }
    }
}
