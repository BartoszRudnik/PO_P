package simulator;

/** Publiczna klasa Pasażera uprzywilejowanego*/
public class PrivilegedPassanger extends Passanger {

    /** Konstruktor PrivilegedPassanger
     * @param startFloor początkowe piętor
     * @param targetFloor docelowe piętro
     * @param startTime początkowy czas
     * */
    PrivilegedPassanger( int startTime, int startFloor, int targetFloor){
        super( startTime, startFloor, targetFloor);
    }

    /** Nadpisana metoda wybierania celu w windzie
     * @param elevator winda do której wsiada pasażer
     * */
    @Override
    public void SelectFloor( IEnterElevator elevator){
        elevator.setTargetFloor(targetFloor, 0);
    }


}
