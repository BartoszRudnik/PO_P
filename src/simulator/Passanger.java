package simulator;

/** Publiczna klasa pasażera*/
public class Passanger implements IEnterElevator, ISelectFloor{
    private int startTime;
    private int startFloor;
    private int targetFloor;


    Passanger( int startTime, int startFloor, int targetFloor){
        this.startTime = startTime;
        this.startFloor = startFloor;
        this.targetFloor = targetFloor;
    }

    public int getStartTime(){
        return startTime;
    }

    public int getStartFloor(){
        return startTime;
    }

    public int getTargetFloor(){
        return targetFloor;
    }

    @Override
    public int SelectFloor(){
        return targetFloor;
    }

    @Override
    public void GetInto(Elevator elevator){

    }

    @Override
    public void GetOut(){
        //TO DO

    }

}
