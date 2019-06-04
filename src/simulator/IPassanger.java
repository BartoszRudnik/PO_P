package simulator;

/** Interfejs wchodzenia i wychodzenia z windy*/
public interface IPassanger {

    /** Metoda wchodzenia do windy*/
    boolean GoInto(IEnterElevator elevator, IPassengerControl floor);

    /** Metoda wychodzenia z windy*/
    void GetOut( IExit elevator);

    void SelectFloor( IEnterElevator elevator);
}