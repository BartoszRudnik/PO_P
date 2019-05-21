package simulator;

/** Publiczny interfejs windy*/
public interface IElevator {
    /** Nadawanie windzie nowego piętra docelowego*/
    void setTargetFloor(int targetFloor);

    /** Metoda ruchu windy */
    void Move();

    /** Metoda pokazująca czy winda jest otwarta */
    boolean showIsOpen();
}
