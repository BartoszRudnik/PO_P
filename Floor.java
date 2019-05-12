package src.simulator;
import java.util.ArrayList;
import java.util.List;

/** Publiczna klasa piętra*/
public class Floor
{
    private int floorNumber;

    /** Lista pasażerów*/
    List<Passanger> passengerList = new ArrayList <>();

    public int getQueueLength()
    {
        return passengerList.size();
    }

/** Metoda dodająca pasażera */
    public void AddPassenger()

    {
        passengerList.add(new Passanger());
    }

    public void LetPassengerOut()
    {
        // ???
    }



}
