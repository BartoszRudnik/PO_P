package simulator;

public interface IEnterElevator extends IPassengerControl {

    boolean showIsOpen();
    int GetNumberOfFreePlaces();
    void OpenDoor();

    /** Metoda nadająca nowe docelowe piętor
     * @param targetFloor docelowe piętro
     */
    void setTargetFloor(int targetFloor);

    /** Metoda nadająca nowe docelowe piorytetowe piętro
     * @param targetFloor docelowe pięro
     * @param priority piorytet
     */
    void setTargetFloor(int targetFloor, int priority);
}
