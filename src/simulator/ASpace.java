package simulator;

import java.util.LinkedList;
import java.util.List;

/** Abstrakcyjna klasa pomieszczenia
 * W pomieszceniu mogą przebywac pasazerowie, mogz byc do niego dodawani lub usuwani
 * */
abstract class ASpace{
    /** Lista pasazerów w pomieszczeniu */
    protected List<Passanger> passengerList = new LinkedList<>();

    /** Metoda dodająca pasazera
     * @param passanger dodawany pasazer
     * */
    public void AddPassenger(Passanger passanger){
        // Dodawanie pasazera
        passengerList.add(passanger);
    }

    /** Metoda wypuszczaąca pasazera
     * @param passenger wypuszczany pasazer*/
    public void LetPassenger(Passanger passenger) {
        // Pasażer jest usuwany z listy pasażerów oczekujących
        passengerList.remove(passenger);
    }

    /** Metoda zwracająca liczbę pasazerow w pomieszczeniu
     * @return liczba pssazerow*/
    int getNumberOfPassanger(){
        return passengerList.size();
    }
}


