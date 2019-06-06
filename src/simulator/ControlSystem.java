package simulator;

import java.util.List;

import static java.lang.Math.abs;

/** Klasa sterująca windami w budynku*/
public class ControlSystem implements IManageElevators{

    /** Metoda zarządzania windami w danym budynku
     * @param floors piętra budynku
     * @param elevators windy budynku
     * */
    @Override
    public void ManageElevators(List<IFloor> floors, List<IElevator> elevators){
        int difference;
        int indexTheLongestQueue = TheLongestQueue(floors);
        for (IElevator elevator : elevators) {
            if (elevator.GetNumberOfFreePlaces() == 0)
                continue;
            difference = abs(elevator.GetCurrentFloor() - indexTheLongestQueue);
            if (elevator.GetNumberOfFreePlaces() == elevator.MaxNumberPassangers()) {
                elevator.setCall(indexTheLongestQueue);
                break;
            } else if (difference < 5 && elevator.GetNumberOfFreePlaces() < 4) {
                elevator.setCall(indexTheLongestQueue);
                break;
            } else if (difference < 4 && elevator.GetNumberOfFreePlaces() > 3) {
                elevator.setCall(indexTheLongestQueue);
            }
        }
    }

    /**Metoda wyznaczajaca indeks pietra z najwieksza kolejka
     * @param floors piętra budynku
     * */
    private int TheLongestQueue(List<IFloor> floors){
        // indeks piętra z największą kolejką
        int theLongestQueue = 0;
        // liczba pasażerów w kolejce z największą liczbą pasażerów
        int numberOfPassengers = 0;
        for( int indexFloor = 0; indexFloor < floors.size(); indexFloor++) {
            if (floors.get(indexFloor).GetQueueLength() > numberOfPassengers) {
                theLongestQueue = indexFloor;
                numberOfPassengers=floors.get(indexFloor).GetQueueLength();
            }
        }
            return theLongestQueue;
    }
}
