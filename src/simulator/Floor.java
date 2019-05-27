package simulator;
import java.util.ArrayList;
import java.util.List;

/**
 * Publiczna klasa piętra
 * Zawiera w sobie kolejkę pasażerów
 * */
public class Floor {

    /** Lista pasażerów*/
    List<Passanger> passengerList = new ArrayList <>();
    /** Numer piętra*/
    private int number;
    /** wezwanie*/
    private boolean call = false;

    /** Konstruktor piętra
     * @param number numer piętra*/
    Floor( int number){
        this.number = number;
    }

    /** Metoda zwracająca numer piętra*/
    public int getNumber() {
        return number;
    }

    /**Metoda Pokazująca długość kolejki*/
    public int GetQueueLength(){
        return passengerList.size();
    }

    /** Metoda dodająca pasażera
     * @param passanger dodawany pasażer
     * */
    public void AddPassenger( Passanger passanger){
        if( passanger instanceof  PrivilegedPassanger){
            passengerList.add(0, passanger);
        }
        else
            passengerList.add(passanger);
    }

    /** Metoda wypuszczania pasażerów do windy
     * @param elevator winda mająca stać na piętrze*/
    public void LetPassengerOut( Elevator elevator) {
        /** Tutaj pasażerowie są dodawani do windy */
        if(passengerList.size() > 0){
            while (passengerList.get(0).GoInto(elevator)){
                // Dodawanie pasażera do windy
                elevator.AddPassanger(passengerList.get(0));
                // Pasażer jest usuwany z listy pasażerów oczekujących
                passengerList.remove(passengerList.get(0));
                if( passengerList.size() < 1){
                    call = false;
                    break;
                }
            }
        }
    }

    /** Metoda wezwania windy*/
    public void CallElevator(){
        call = true;
    }

    public boolean getCall(){
        return call;
    }
}
