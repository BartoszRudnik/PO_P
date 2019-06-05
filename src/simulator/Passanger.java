package simulator;

/** Publiczna klasa pasażera*/
public class Passanger implements IPassanger {
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

    /** Metoda zwacająca czas pojawienia się na piętrze */
    public int getStartTime(){
        return startTime;
    }

    /** Metoda zwacająca piętro początkowe pasażera */
    public int getStartFloor(){
        return startFloor;
    }

    /** Metoda zwacająca piętro docelowe pasażera*/
    public int getTargetFloor(){
        return targetFloor;
    }

    /** Metoda wyboru piętra
     * @param elevator winda
     */
    @Override
    public void SelectFloor( IEnterElevator elevator){
        elevator.setTargetFloor(targetFloor);
    }

    /**
     * Metoda wchodzenia do windy
     * Pasażer wchodzi do windy jeśli w windzie jest miejsce
     * @param elevator winda oczekująca na piętrze
     * @param floor piętro
     * */
    public boolean GoInto(IEnterElevator elevator, IPassengerControl floor){
        // Otwórz drzwi windy jeśli nie są otwarte
        if(!elevator.showIsOpen()){
            elevator.OpenDoor();
        }
        if(elevator.GetNumberOfFreePlaces()>0){

            elevator.AddPassenger(this);
            floor.LetPassenger(this);
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
     * @param elevator winda
     * */
    public void GetOut(IExit elevator){
        if(elevator.GetCurrentFloor() == targetFloor)
            elevator.LetPassenger(this);
    }

    /** Metoda wezwania windy
     * @param floor piętro
     * */
    public void CallElevator( IFloor floor){
        floor.CallElevator();
    }
}
