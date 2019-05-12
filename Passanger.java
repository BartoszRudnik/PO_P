package src.simulator;

import java.util.Random;

public class Passanger implements IEnterElevator, ISelectFloor
{
    private int targetFloor;
    private int timeAppear;
    private int placeInTheQueue;

    /** konstruktor bezparametrowy */

    public Passanger()
    {}
/** konstruktor parametrowy */

    public Passanger( int targetFloor,int timeAppear,int placeInTheQueue)
    {
        this.targetFloor = targetFloor;
        this.timeAppear = timeAppear;
        this.placeInTheQueue = placeInTheQueue;
    }

/** wybór pasażera, (losowanie) piętra od 0 do 10 */
    @Override
    public int SelectFloor()
    {
        Random r = new Random();
        targetFloor = r.nextInt(11);
        return targetFloor;
    }

    @Override
    public void GetInto()
    {
        // ta metoda powoduje inkrementacje(pojemności) w windzie
    }

    @Override
    public void GetOut()
    {
        // ta metoda powoduje dekrementacje(pojemności) w windzie

    }

}
