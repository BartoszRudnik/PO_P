package src.simulator;


public class PrivilegedPassanger extends Passanger
{
    public PrivilegedPassanger( int targetFloor,int timeAppear,int placeInTheQueue)
    {
        super(targetFloor,timeAppear,placeInTheQueue);
    }

    /** Metoda wyboru piętra dziedziczona */
    @Override
    public int SelectFloor()
    {
        return super.SelectFloor();
    }

    /** Metoda ustawiająca pasażera na początku kolejki*/
    public void SetYourselfFirstInQueue()
    {
        // metoda która ,,wpisuje" pasażera na początek listy ( na indeks 0 )
    }


}
