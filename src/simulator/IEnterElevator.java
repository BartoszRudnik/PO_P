package simulator;

/** Interfejs wchodzenia i wychodzenia z windy*/
public interface IEnterElevator {

    /** Metoda wchodzenia do windy*/
    void GetInto(Elevator elevator);

    /** Metoda wychodzenia z windy*/
    void GetOut();
}
