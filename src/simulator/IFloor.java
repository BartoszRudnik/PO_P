package simulator;

public interface IFloor {

    int GetQueueLength();

    /** Metoda dodająca pasażera
     * @param passanger
     */
    void AddPassenger( Passanger passanger);
    boolean getCall();
    void CallElevator();
}
