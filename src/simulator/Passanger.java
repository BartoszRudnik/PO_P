package simulator;

/** Publiczna klasa pasażera*/
public class Passanger implements IEnterElevator, ISelectFloor{\
    protected int startTime;
    protected int startFloor;
    protected int targetFloor;


    Passanger( int startTime, int startFloor, int targetFloor){
        this.startTime = targetFloor;
        this.startFloor = targetFloor;
        this.targetFloor = targetFloor;
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
