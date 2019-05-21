package simulator;

/** Publiczna klasa Pasażera uprzywilejowanego*/
public class PrivilegedPassanger extends Passanger {
    /** Knstruktor PrivilegedPassanger*/
    PrivilegedPassanger( int startTime, int startFloor, int targetFloor){
        super( startTime, startFloor, targetFloor);
    }

    /** Nadpisana metoda wybierania celu w windzie*/
    @Override
    public void SelectFloor( Elevator elevator){
        elevator.setTargetFloor(targetFloor, 0);
    }

    /** Metoda ustawiająca pasażera na początku kolejki*/
    public void SetYourselfFirstInQueue(){
        //TODO
    }
}
