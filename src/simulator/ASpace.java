package simulator;

import java.util.LinkedList;
import java.util.List;

/** Abstrakcyjna klasa pomieszczenia
 * W pomieszceniu mogą przebywać pasażerowie, mogą być do niego dodawani lub usuwani
 * */
abstract class ASpace{
    /** Lista pasażerów w pomieszczeniu */
    protected List<Passanger> passengerList = new LinkedList<>();

    /** Metoda dodająca pasażera
     * @param passanger dodawany pasażer
     * */
    public void AddPassenger(Passanger passanger){
        // Dodawanie pasażera
        passengerList.add(passanger);
    }

    /** Metoda wypuszczaąca pasażera
     * @param passenger wypuszczany pasażer*/
    public void LetPassenger(Passanger passenger) {
        // Pasażer jest usuwany z listy pasażerów oczekujących
        passengerList.remove(passenger);
    }

    /** Metoda zwracająca liczbę pasażerów w pomieszczeniu
     * @return numberOfPassangers*/
    int getNumberOfPassanger(){
        return passengerList.size();
    }
}


