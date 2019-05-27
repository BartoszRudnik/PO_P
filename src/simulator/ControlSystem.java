package simulator;

import static java.lang.Math.abs;

/** Klasa sterująca windami w budynku*/
public class ControlSystem implements IManageElevators{

    /** Metoda zarządzania windami w danym budynku
     * @param building
     * */
    @Override
    public void ManageElevators(Building building){
        int diference;
        int indexTheLongestQueue = TheLongestQueue(building);
        for( int i = 0; i < building.GetNumberOfElevators(); i++){
            Elevator elevator = building.GetElevator(i);
            if(elevator.GetNumberOfFreePlaces() == 0)
                continue;
            diference = abs(elevator.GetCurrentFloor()-indexTheLongestQueue);
            if(elevator.GetNumberOfFreePlaces() == elevator.MaxNumberPassangers()){
                elevator.setCall(indexTheLongestQueue);
                break;
            }
            else if( diference < 5 && elevator.GetNumberOfFreePlaces() < 4){
                elevator.setCall(indexTheLongestQueue);
                break;
            }
            else if(diference < 4 && elevator.GetNumberOfFreePlaces() > 3){
                elevator.setCall(indexTheLongestQueue);
            }
        }
    }

    private int TheLongestQueue(Building building){
        int theLongestQueue = 0;
        int numberOfPasseggers = 0;
        for( int indexFloor = 0; indexFloor > building.GetNumberOfFloors(); indexFloor++)
            if(building.GetFloor(indexFloor).GetQueueLength() > numberOfPasseggers)
                theLongestQueue = indexFloor;
            return theLongestQueue;
    }


}
