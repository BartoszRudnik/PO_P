package simulator;

/** Publiczna klasa pasażera*/
public class Passanger implements ISelectFloor, IEnterElevator{
    /** Pole zapisujące czas startu pasażera*/
    protected int startTime;
    /** Pole zapisujące piętro startu pasażera*/
    protected int startFloor;
    /** Pole zapisujące piętro docelowe pasażera*/
    protected int targetFloor;

    /** Konstruktor pasażera
     * @param startTime czas startu
     * @param startFloor piętro startowe
     * @param targetFloor piętro docelowe
     * */
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

    /** Metoda zwacająca piętro docelowe pasażera*/
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
     * @param elevator winda oczekująca na piętrze
     * */
    public boolean GoInto(Elevator elevator){
        // Otwórz drzwi windy jeśli nie są otwarte
        if(!elevator.showIsOpen()){
            elevator.OpenDoor();
        }
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
