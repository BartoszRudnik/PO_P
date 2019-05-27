package simulator;

import static java.lang.Math.abs;

/** Klasa sterująca windami w budynku*/
public class ControlSystem implements IManageElevators{

    /** Metoda zarządzania windami w danym budynku
     * @param building
     * */
    @Override
    public void ManageElevators(Building building){
        int difference;
        int indexTheLongestQueue = TheLongestQueue(building);
        for( int i = 0; i < building.GetNumberOfElevators(); i++){
            Elevator elevator = building.GetElevator(i);
            if(elevator.GetNumberOfFreePlaces() == 0)
                continue;
            difference = abs(elevator.GetCurrentFloor()-indexTheLongestQueue);
            if(elevator.GetNumberOfFreePlaces() == elevator.MaxNumberPassangers()){
                elevator.setCall(indexTheLongestQueue);
                break;
            }
            else if( difference < 5 && elevator.GetNumberOfFreePlaces() < 4){
                elevator.setCall(indexTheLongestQueue);
                break;
            }
            else if(difference < 4 && elevator.GetNumberOfFreePlaces() > 3){
                elevator.setCall(indexTheLongestQueue);
            }
        }
    }

    /**Metoda wyznaczajaca indeks pietra z najwieksza kolejka*/
    private int TheLongestQueue(Building building){
        int theLongestQueue = 0;
        int numberOfPassengers = 0;
        for( int indexFloor = 0; indexFloor < building.GetNumberOfFloors(); indexFloor++) {
            if (building.GetFloor(indexFloor).GetQueueLength() > numberOfPassengers) {
                theLongestQueue = indexFloor;
                numberOfPassengers=building.GetFloor(indexFloor).GetQueueLength();
            }
        }
            return theLongestQueue;
    }


}
