package simulator;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Klasa symulacji
 * Główna klasa pliku, zawiera funkcją main
  * */
public class Simulator extends ActionListener{
    private Timer timer;
    private Building building;
    private PassengerCreator passengerCreator;
    private ControlSystem control;
    private int delay = 1000;
    private int time = 0;

    public int time = 0;

    Simulator(int numberOfFloors, int numberOfElevators){
        building = new Building( numberOfFloors, numberOfElevators);
        passengerCreator = new PassengerCreator(numberOfFloors);
        control = new ControlSystem();
    }

}
