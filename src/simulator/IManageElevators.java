package simulator;

/** Publiczny interfejs zarządzania Elevators */
public interface IManageElevators {

    /** Metoda zarządzania windami (Elevator) */
    void ManageElevators(Building building);

    /** Metoda sprawdzania na którym piętrze (Floor) znajduje się najwięcej pasażerów (Passanger)
     * Zwraca numer piętra z największą ilością pasażerów */
    int CheckOnWhichFloorTheMostPassangers(Building building);

    /** Metoda sprawdzania liczby pasażerów w windzie (Elevator)
    void CheckTheNumberOfElevatorPassangers(); */

    /** Metoda nadawania nowego docelowego piętra (Floor) dla danej windy (Elevator)*/
    void setTheNewTargetElevator(Elevator elevator, int newTarget);
}
