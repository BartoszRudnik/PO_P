package simulator;

public interface IElevatorSpecial  {

    /** Metoda pokazująca czy winda jest otwarta */
    boolean showIsOpen();

    /** Nadawanie windzie nowego piętra docelowego
     * @param targetFloor piętro docelowe
     **/
    void setTargetFloor(int targetFloor);

    /** Metoda zwracająca liczbę wolnych miejsc w windzie */
    int GetNumberOfFreePlaces();
}
