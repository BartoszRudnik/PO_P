package simulator;

/** Interfejs wchodzenia i wychodzenia z windy*/
public interface IPassanger {

    /** Metoda wchodzenia do windy
     * @param elevator windy budynku
     * @param floor piętra budynku
     * */
    boolean GoInto(IEnterElevator elevator, IPassengerControl floor);

    /** Metoda wychodzenia z windy
     * @param elevator
     * */
    void GetOut( IExit elevator);

    /** Metoda wyboru piętra
     * @param elevator
     */
    void SelectFloor( IEnterElevator elevator);
}