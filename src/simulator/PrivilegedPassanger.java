package simulator;

/** Publiczna klasa Pasażera uprzywilejowanego*/
public class PrivilegedPassanger extends Passanger {
    PrivilegedPassanger( int targetFloor){
        super(targetFloor);
        SetYourselfFirstInQueue();
    }

    /** Metoda ustawiająca pasażera na początku kolejki*/
    public void SetYourselfFirstInQueue(){
        // TO DO
    }
}
