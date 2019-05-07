package simulator;

/** Publiczna klasa pasażera*/
public class Passanger implements IEnterElevator, ISelectFloor{
    int targetFloor;
    Passanger( int targetFloor){
        this.targetFloor = targetFloor;
    }

    @Override
    public int SelectFloor(){
        //TO DO
    }

    @Override
    public void GetInto(){
        //TO DO
    }

    @Override
    public void GetOut(){
        //TO DO
    }

}
