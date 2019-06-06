package simulator;

/** Publiczny interfejs windy*/
public interface IElevator extends IElevatorSpecial {

    /** Metoda ruchu windy */
    void Move();

    /** Metoda zwracająca obecne piętro */
    int GetCurrentFloor();

    /** Metoda zwracająca maksymalną liczbę pasażerów w windzie */
    int MaxNumberPassangers();

    /** Nadanie nowego wezwania
     *  @param floor piętro na które jest wzywana winda
     */
    void setCall(int floor);
}
