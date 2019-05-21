package simulator;

/** Publiczna klasa pasażera*/
public class Passanger implements ISelectFloor, IEnterElevator{
    protected int startTime;
    protected int startFloor;
    protected int targetFloor;

    /** Konstruktor pasażera*/
    Passanger( int startTime, int startFloor, int targetFloor){
        this.startTime = startTime;
        this.startFloor = startFloor;
        this.targetFloor = targetFloor;
    }

    /** Metoda zwacająca czas pojawienia się na piętrze*/
    public int getStartTime(){
        return startTime;
    }

    /** Metoda zwacająca piętro początkowe pasażera*/
    public int getStartFloor(){
        return startTime;
    }

    /** Metoda zwacająca piętro docelowepasażera*/
    public int getTargetFloor(){
        return targetFloor;
    }

    @Override
    public void SelectFloor( Elevator elevator){
        elevator.setTargetFloor(targetFloor);
    }

    /**
     * Metoda wchodzenia do windy
     * Pasażer wchodzi do windy jeśli w windzie jest miejsce
     * */
    public boolean GoInto(Elevator elevator){
        if(elevator.GetNumberOfFreePlaces()>0){
            SelectFloor(elevator);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Metoda wychodzenia z windy
     * Pasażer wychodzi z windy jeśli obecne piętro jest jego docelowym piętrem
     * */
    public boolean GetOut( int currentFloor){
        if( currentFloor == targetFloor){
            return true;
        }
        else{
            return false;
        }

    }
}
