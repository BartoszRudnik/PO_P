package simulator;

/** Interfejs wchodzenia i wychodzenia z windy*/
public interface IEnterElevator {

    /** Metoda wchodzenia do windy*/
    boolean GoInto(Elevator elevator);

    /** Metoda wychodzenia z windy*/
    boolean GetOut( int currentFloor);
}