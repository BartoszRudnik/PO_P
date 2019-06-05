package simulator;

public interface IExit {

    /**
     * @param passenger
     * */
    void LetPassenger(Passanger passenger);

    /** Metoda zwracająca obecne piętro */
    int GetCurrentFloor();
}
