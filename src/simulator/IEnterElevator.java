package simulator;

/**
 * Ogólny interfejs dodawania pasażera do windy
 */
public interface IEnterElevator extends IElevatorSpecial{

    /** Metoda otwierająca dzwi windy */
    void OpenDoor();

    /**
     * Metoda nadająca nowe docelowe piorytetowe piętro
     * @param targetFloor docelowe pięro
     * @param priority piorytet
     */
    void setTargetFloor(int targetFloor, int priority);

    /** Metoda dodająca pasażera */
    void AddPassenger(Passanger passanger);
}
