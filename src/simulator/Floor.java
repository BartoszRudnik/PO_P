package simulator;
import java.util.ArrayList;
import java.util.List;

/** Publiczna klasa piętra*/
public class Floor {
    /** Lista pasażeró*/
    List<Passanger> passengerList = new ArrayList <>();

    /**Metoda Pokazująca długość kolejki*/
    public int GetQueueLength(){
        return passengerList.size();
    }

    /** Metoda dodająca pasażera */
    public void AddPassenger( Passanger passanger)

    {
        passengerList.add(passanger);
    }

    public void LetPassengerOut( Elevator elevator)
    {
        // Pole liczby wolnych miejsc w windzie
        int freePlaces = elevator.GetNumberOfFreePlaces();

        /** Tutaj pasażerowie są dodawani do windy */
        for( int i = 0; i < freePlaces; i++)
        {
            // Wchodzenie pasażera do windy
            passengerList.get(i).GetInto(elevator);
            // Pasażer jest usuwany z listy pasażerów piętra
            passengerList.remove(passengerList.get(i));
        }
    }
}
