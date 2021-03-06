package simulator;

/**
 * Interfejs wychodzenia z windy
 */
public interface IExit {

    /**
     * Wypuszczanie pasażera
     * @param passenger wypuszczany pasażer
     * */
    void LetPassenger(Passanger passenger);

    /** Metoda zwracająca obecne piętro */
    int GetCurrentFloor();
}
