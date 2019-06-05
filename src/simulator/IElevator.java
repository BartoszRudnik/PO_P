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

    /** Metoda liczbę wolnych miejsc w windzie */
    int GetNumberOfFreePlaces();

    /** Metoda zwracająca obecne piętro */
    int GetCurrentFloor();

    /** Metoda zwracająca maksymalną liczbę pasażerów w windzie */
    int MaxNumberPassangers();
    /**
     *  @param floor
     */
    void setCall(int floor);
}
