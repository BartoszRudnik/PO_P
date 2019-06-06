package simulator;

/** Publiczny interfejs windy*/
public interface IElevator {

    /** Nadawanie windzie nowego piętra docelowego
     * @param targetFloor piętro docelowe
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

    /** Nadanie nowego wezwania
     *  @param floor piętro na które jest wzywana winda
     */
    void setCall(int floor);
}
