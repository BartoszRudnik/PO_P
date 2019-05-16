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

    /**Metoda Pokazująca długość kolejki*/
    public int GetQueueLength(){
        return passengerList.size();
    }

    /** Metoda dodająca pasażera */
    public void AddPassenger( Passanger passanger){
        passengerList.add(passanger);
    }

    public void LetPassengerOut( Elevator elevator) {
        /** Tutaj pasażerowie są dodawani do windy */
        while (passengerList.get(0).GoInto(elevator) == true) {
            // Dodawanie pasażera do windy
            elevator.AddPassanger(passengerList.get(0));
            // Pasażer jest usuwany z listy pasażerów oczekujących
            passengerList.remove(passengerList.get(0));
        }
    }
}
