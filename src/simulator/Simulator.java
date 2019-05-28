package simulator;

/* Klasa symulacji
 * Główna klasa pliku, zawiera funkcją main
  * */
public class Simulator{

    Simulator(int numberOfFloors, int numberOfElevators){
        Building building = new Building( numberOfFloors, numberOfElevators);
        ControlSystem control = new ControlSystem();
    }

}
