package simulator;

public interface IPassengerControl {

    /** Metoda dodająca pasażera
     * @param passenger psażer
     */
    void AddPassenger(Passanger passenger);

    /** Metoda zwalniająca pasażera
     * @param passenger pasażer
     */
    void LetPassenger(Passanger passenger);
}
