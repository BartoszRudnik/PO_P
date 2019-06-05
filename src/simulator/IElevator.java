package simulator;

/** Publiczny interfejs windy*/
public interface IElevator {

    /** Nadawanie windzie nowego piętra docelowego
     * @param targetFloor
     **/
    void setTargetFloor(int targetFloor);

    /** Metoda ruchu windy */
    void Move();

    /** Metoda pokazująca czy winda jest otwarta */
    boolean showIsOpen();

    int GetNumberOfFreePlaces();

    int GetCurrentFloor();

    int MaxNumberPassangers();

    void setCall(int floor);
}
