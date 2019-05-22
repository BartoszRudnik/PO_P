package simulator;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

/** Publiczna klasa windy*/
public class Elevator implements IElevator {
    // Pole liczby jednostek czasu otwarcia windy
    private int timeOpen = 1;
    // Pole mówiące o tym, czy winda jest otwarta
    private boolean isOpen;
    // Pole maksymalnej liczby pasażerów
    private int maxNumberOfPassanger;
    // Pole obecnego piętra windy
    private int currentFloor;
    // Pole piętra, na które winda została wezwana
    private Floor call = null;
    // Lista pasażerów windy
    private List<Passanger> passengerList = new ArrayList<>();
    // Lista wybranych pięter
    private List<Integer> listTargetFloors = new ArrayList<>();


    /** @param maxNumberOfPassanger Konstruktor windy*/
    Elevator( int maxNumberOfPassanger){
        this.maxNumberOfPassanger = maxNumberOfPassanger;
        currentFloor = 0;
        isOpen = false;
    }

    /** Metoda zwracająza obecne piętro windy*/
    public int GetCurrentFloor(){
        return currentFloor;
    }

    /** Metoda zwracająca liczbę wolnych miejsc w windzie*/
    public int GetNumberOfFreePlaces(){
        return maxNumberOfPassanger - passengerList.size();
    }

    /**
     * Metoda nadająca docelowe piętro windzie
     * Dodaje je na koniec listy, jeśli nie zostało dodane wcześniej
     * @param targetFloor nowe piętro celu windy
     * */
    @Override
    public void setTargetFloor(int targetFloor){
        // Pole informujące czy na liście jest już dany cel
        boolean addNew = true;
        for( int i = 0; i < listTargetFloors.size(); i++){
            if (targetFloor == listTargetFloors.get(i)) {
                addNew = false;
            }
        }
        if(addNew)
            listTargetFloors.add(targetFloor);
    }

    /**
     * Metoda nadająca docelowe piętro windzie o większym piorytecie
     * */
    public void setTargetFloor(int targetFloor, int priority){
        listTargetFloors.add(priority, targetFloor);
    }

    /** Metoda nadająca nowe wezwanie*/
    public void setCall( Floor newCall){
        call = newCall;
    }

    /** Metoda dodająca pasażera do windy*/
    public void AddPassanger( Passanger passanger){
        passengerList.add(passanger);
    }

    /** Metoda ruchu windy */
    @Override
    public void Move(){
        // Pole piętra docelowego
        int targetFloor;
        // Pole dystansu między piętrem wezwanym a obecnym
        int difference;
        /** Jeśli winda została wezwana i posiada wybrane piętra*/
        if(call != null && listTargetFloors.size() != 0){
            difference = abs(call.getNumber() - currentFloor);
            // Jeśli winda ma niewielki dystans do wezwanego piętra to tam jedzie
            if( difference < 4){
                targetFloor = call.getNumber();
            }
            else{
                targetFloor = listTargetFloors.get(0);
            }
        }
        /** Jeśli winda została wezwana i nie posada żadych celów*/
        else if(call != null){
            targetFloor = call.getNumber();
        }
        /**Jeśli winda nie została wezwana i ma cele*/
        else if( listTargetFloors.size() != 0){
            targetFloor = listTargetFloors.get(0);
        }
        /** Jeśli warunki nie spełnione*/
        else{
            isOpen = false;
            return;
        }
        /** Jeśli winda jest zamknięta to może się poruszać*/
        if( isOpen == false){

            //Jeśli docelowe piętro jest wyżej od obecnego to jedź w górę
            if( targetFloor > currentFloor){
                GoUp();
            }
            //Jeśli docelowe piętro jest niżej od obecnego to jedź w dół
            else if( targetFloor < currentFloor){
                GoDown();
            }
            //W przeciwnym wypadku jesteś na piętrze docelowym, więc wysadź pasażerów
            else{
                setOpenElevator(true);
                timeOpen = 1;
                LetPassenger();
            }
        }
        else{
            if(timeOpen < 1)
                setOpenElevator(false);
            else
                timeOpen--;
        }
    }

    /** Metoda pokazująca czy winda jest otwarta */
    public  boolean showIsOpen(){
        return isOpen;
    }

    /** Metoda wypuszczająca pasażerów z windy*/
    private void LetPassenger(){
        for(int number = 0; number < passengerList.size(); number++){

            // Sprawdzanie czy obecne piętro jest piętrem docelowym danego pasażera windy
            if( passengerList.get(number).GetOut(currentFloor)){
                passengerList.remove(number);
                number--;
            }
        }
        // Usuwanie danego piętra z listy pięter docelowych
        listTargetFloors.remove(0);
    }

    /** Metoda jazdy windy w górę*/
    private void GoUp(){
        currentFloor++;
    }

    /** Metoda jazdy windy w dół*/
    private void GoDown(){
        currentFloor--;
    }

    /** @param isOpen Metoda otwierająca lub zamykająca windę */
    private void setOpenElevator( boolean isOpen){
        this.isOpen = isOpen;
    }
}
