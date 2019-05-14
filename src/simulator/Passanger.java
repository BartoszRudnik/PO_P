package simulator;

/** Publiczna klasa pasażera*/
public class Passanger implements IEnterElevator, ISelectFloor{
    int targetFloor;

    Passanger( int targetFloor){
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
