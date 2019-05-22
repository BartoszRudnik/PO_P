package simulator;

/** Publiczna klasa Pasażera uprzywilejowanego*/
public class PrivilegedPassanger extends Passanger {

    /** Konstruktor PrivilegedPassanger*/
    PrivilegedPassanger( int startTime, int startFloor, int targetFloor){
        super( startTime, startFloor, targetFloor);
    }

    /** Nadpisana metoda wybierania celu w windzie
     * @param elevator winda do której wsiada pasażer
     * */
    @Override
    public void SelectFloor( Elevator elevator){
        elevator.setTargetFloor(targetFloor, 0);
    }
}
