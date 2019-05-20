package simulator;

import java.util.ArrayList;
import java.util.List;

/** Publiczna klasa windy*/
public class Elevator implements IElevator {
    private int maxNumberOfPassanger;
    private int currentFloor;
    private int targetFloor;
    private List<Passanger> passengerList = new ArrayList<>();

    /** Konstruktor windy*/
    Elevator( int maxNumberOfPassanger){
        this.maxNumberOfPassanger = maxNumberOfPassanger;
        currentFloor = 1;
    }

    public int GetCurrentFloor(){
        return currentFloor;
    }

    /** Metoda zwracająca liczbę wolnych miejsc w windzie*/
    public int GetNumberOfFreePlaces(){
        return maxNumberOfPassanger - passengerList.size();
    }

    /** Metoda nadająca docelowe piętro windzie*/
    public void setTargetFloor(int targetFloor){
        this.targetFloor = targetFloor;
    }

    /** Metoda dodająca pasażera do windy*/
    public void AddPassanger( Passanger passanger){
        passengerList.add(passanger);
    }

    /** Metoda wypuszczająca pasażerów z windy*/
    public void LetPassenger(){
        for(int number = 0; number < passengerList.size(); number++){

            // Sprawdzanie czy obecne piętro jest jego piętrem docelowym
            if( passengerList.get(number).GetOut(currentFloor)){
                passengerList.remove(number);
                number--;
            }
        }
    }

    /** Metoda ruchu windy */
    public void Move(){
        /**
         * Jeśli docelowe piętro jest wyżej od obecnego to jedź w górę
         * Jeśli docelowe piętro jest niżej od obecnego to jedź w dół
         * W przeciwnym wypadku jesteś na piętrze docelowym, więc wysadź pasażerów
         */
        if( targetFloor > currentFloor){
            GoUp();
        }
        else if( targetFloor < currentFloor){
            GoDown();
        }
        else{
            LetPassenger();
        }
    }

    /** Metoda jazdy windy w górę*/
    private void GoUp(){
        currentFloor++;
    }

    /** Metoda jazdy windy w dół*/
    private void GoDown(){
        currentFloor--;
    }

    /** Metoda sprawdzająca obecność pasażerów uprzywilejowanych w windzie */

    public boolean CheckIsPrivilegedPassengerInElevator()
    {
        if(passengerList.contains(PrivilegedPassanger))
            return true;
        else
            return false;
    }

}
