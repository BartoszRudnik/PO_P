package simulator;

/** Publiczny interfejs zarządzania Elevators */
public interface IManageElevators {
    /** Metoda zarządzania windami (Elevator) */
    void ManageElevators();
    /** Metoda sprawdzania na którym piętrze (Floor) znajduje się najwięcej pasażerów (Passanger)
     * Zwraca numer piętra z największą ilością pasażeró */
    int CheckOnWhichFloorTheMostPassangers();
    /** Metoda sprawdzania liczby pasażerów w windzie (Elevator) */
    void CheckTheNumberOfElevatorPassangers();
    /** Metoda nadawania nowego docelowego piętra (Floor) dla danej windy (Elevator)*/
    void GiveTheNewTargetElevator(Elevator);
}
