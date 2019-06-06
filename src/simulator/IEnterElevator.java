package simulator;

public interface IEnterElevator {

    /** Metoda informująca o otwarych drzwiach windy */
    boolean showIsOpen();

    /** Metoda zwracająca liczbę wolnych miejsc w windzie */
    int GetNumberOfFreePlaces();

    /** Metoda otwierająca dzwi windy */
    void OpenDoor();

    /**
     * Metoda nadająca nowe docelowe piętor
     * @param targetFloor docelowe piętro
     */
    void setTargetFloor(int targetFloor);

    /**
     * Metoda nadająca nowe docelowe piorytetowe piętro
     * @param targetFloor docelowe pięro
     * @param priority piorytet
     */
    void setTargetFloor(int targetFloor, int priority);
}
