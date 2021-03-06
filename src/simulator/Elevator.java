package simulator;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;

/** Publiczna klasa windy*/
public class Elevator extends ASpace implements IElevator, IEnterElevator, IExit {

    /** Publiczne pole lancucha zawierajacego informacje o windzie*/
    public String information = "-";

    /** Pole liczby jednostek czasu otwarcia windy */
    private int timeOpen = 1;
    /** Pole mowiące o tym, czy winda jest otwarta */
    private boolean isOpen;
    // Pole maksymalnej liczby pasażerów
    private int maxNumberOfPassanger;
    // Pole obecnego piętra windy
    private int currentFloor;
    // Pole piętra, na które winda została wezwana
    private int call = -1;
    /** Lista wybranych pieter */
    private List<Integer> listTargetFloors = new LinkedList<>();

    /** Konstruktor windy
     * @param maxNumberOfPassanger maksymalna liczba pasażerów
     *`*/
    Elevator( int maxNumberOfPassanger){
        this.maxNumberOfPassanger = maxNumberOfPassanger;
        currentFloor = 0;
        isOpen = false;
    }

    /** Metoda zwracajaca maksymalna liczbe pasazerow w windzie
     * @return  maxNumberOfPassanger */
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

    /** Metoda zwracająca cel udania się windy */
    public int GetTargetFloor(){
        if(listTargetFloors.size() > 0)
            return listTargetFloors.get(0);
        return currentFloor;
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
        if( listTargetFloors.size() > 0)
            for (int i: listTargetFloors) {
                if (targetFloor == i) {
                    addNew = false;
                }
            }
        if(addNew)
            listTargetFloors.add(targetFloor);
    }

    /**Metoda nadająca docelowe piętro windzie o większym piorytecie
     * @param targetFloor pietro docelowe
     * @param priority piorytet
     * */
    @Override
    public void setTargetFloor(int targetFloor, int priority){
        listTargetFloors.add(priority, targetFloor);
    }

    /** Metoda nadająca nowe wezwanie*/
    @Override
    public void setCall( int newCall){
        call = newCall;
    }

    /** Metoda ruchu windy */
    @Override
    public void Move(){
        //zmienna ruchu windy
        boolean move = checkCall();

        if( passengerList.size() > maxNumberOfPassanger - 1){
            setOpenElevator(false);
        }

        // Jeśli winda jest zamknięta to może się poruszać*/
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
                LetPassengers();
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
    @Override
    public void OpenDoor(){
        information = "Winda ma otwarte drzwi";
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
        }
        if(listTargetFloors.size() == 0 && passengerList.size() > 0){
            for( Passanger passanger: passengerList){
                passanger.SelectFloor(this);
            }
        }
        return (listTargetFloors.size() != 0);
    }

    /** Metoda wypuszczająca pasażerów z windy*/
    private void LetPassengers(){
        information = "Pasażerowie wychodzą z windy";
        for(int number = 0; number < passengerList.size(); number++){
            passengerList.get(number).GetOut(this);
        }
        // Usuwanie danego piętra z listy pięter docelowych
        for( int i = 0; i < listTargetFloors.size(); i++){
            if( listTargetFloors.get(i) == currentFloor){
                listTargetFloors.remove(listTargetFloors.get(i));
            }
        }
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
