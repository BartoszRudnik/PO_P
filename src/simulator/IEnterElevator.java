package simulator;

public interface IEnterElevator extends IElevatorSpecial{

    /** Metoda otwierająca dzwi windy */
    void OpenDoor();

    /**
     * Metoda nadająca nowe docelowe piorytetowe piętro
     * @param targetFloor docelowe pięro
     * @param priority piorytet
     */
    void setTargetFloor(int targetFloor, int priority);

    void AddPassenger(Passanger passanger);
}
