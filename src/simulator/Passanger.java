package simulator;

/** Publiczna klasa pasażera*/
public class Passanger implements ISelectFloor{
    private int startTime;
    private int startFloor;
    private int targetFloor;

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
    public int SelectFloor(){
        return targetFloor;
    }
}
