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
    private int call = -1;
    // Lista pasażerów windy
    private List<Passanger> passengerList = new ArrayList<>();
    // Lista wybranych pięter
    private List<Integer> listTargetFloors = new ArrayList<>();

    public String information;


    /** @param maxNumberOfPassanger Konstruktor windy*/
    Elevator( int maxNumberOfPassanger){
        this.maxNumberOfPassanger = maxNumberOfPassanger;
        currentFloor = 0;
        isOpen = false;
    }
    /** Metoda zwracajaca maksymalna liczbe pasazerow w windzie*/
    public int MaxNumberPassangers()
    {
        return maxNumberOfPassanger;
    }

    /** Metoda zwracająza obecne piętro windy*/
    public int GetCurrentFloor(){
        return currentFloor;
    }

    /** Metoda zwracająca liczbę wolnych miejsc w windzie*/
    public int GetNumberOfFreePlaces(){
        return maxNumberOfPassanger - passengerList.size();
    }

    public int getTargetFloor(){
        return listTargetFloors.get(0);
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
        for (int i: listTargetFloors) {
            if (targetFloor == listTargetFloors.get(i)) {
                addNew = false;
            }
        }

        /*for( int i = 0; i < listTargetFloors.size(); i++){
            if (targetFloor == listTargetFloors.get(i)) {
                addNew = false;
            }
        }*/
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
    public void setCall( int newCall){
        call = newCall;
    }

    /** Metoda ozwacające piętro na które została wezwana winda*/
    public int getCallFloor() {
        return call;
    }

    /** Metoda dodająca pasażera do windy*/
    public void AddPassanger( Passanger passanger){
        passengerList.add(passanger);
    }

    /** Metoda ruchu windy */
    @Override
    public void Move(){
        boolean move = checkCall();

        /** Jeśli winda jest zamknięta to może się poruszać*/
        if( !isOpen && move ){

            //Jeśli docelowe piętro jest wyżej od obecnego to jedź w górę
            if( listTargetFloors.get(0) > currentFloor){
                GoUp();
            }
            //Jeśli docelowe piętro jest niżej od obecnego to jedź w dół
            else if( listTargetFloors.get(0) < currentFloor){
                GoDown();
            }
            //W przeciwnym wypadku jesteś na piętrze docelowym, więc wysadź pasażerów
            else{
                setOpenElevator(true);
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
    @Override
    public  boolean showIsOpen(){
        return isOpen;
    }

    /** Metoda otwierania windy*/
    public void OpenDoor(){
        setOpenElevator(true);
    }

    /** Metoda sprawdzająca czy winda powinna jechać*/
    private boolean checkCall(){
        int difference;
        if(call >= 0){
            if(listTargetFloors.size() != 0){
                difference = abs(call - currentFloor);
                if(difference < 4){
                    setTargetFloor(call, 0);
                    call = -1;
                }
            }
            else{
                setTargetFloor(call);
                call = -1;
            }
            return true;
        }
        else if(listTargetFloors.size() != 0) {
            return true;
        }
        else
            return false;
    }

    /** Metoda wypuszczająca pasażerów z windy*/
    private void LetPassenger(){
        information = "Pasażerowie wychodzą z windy";
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
        information = "Winda jedzie w górę";
    }

    /** Metoda jazdy windy w dół*/
    private void GoDown(){
        currentFloor--;
        information = "Winda jedzie w dół";
    }

    /** @param isOpen Metoda otwierająca lub zamykająca windę */
    private void setOpenElevator( boolean isOpen){
        this.isOpen = isOpen;
        timeOpen = 1;
    }
}
