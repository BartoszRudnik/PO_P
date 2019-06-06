package simulator;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasa tworząca wszystkie obiekty pasarzerów w symulacji
 * Wyorzystując klasę ReadData tworzy pasażerów argumentami dostarczonymi przez nią
 * */
public class PassengerCreator
{
    /** Pole zawierające liczbę danych pasażerów, które zawiera ReadData*/
    private int numberOfPassengers;

    /** Lista pasażerów w całym programie*/
    private List<Passanger> passangerList = new LinkedList<>();

    PassengerCreator( int numberOfFloors)
    {
        // Wyznaczamy liczbe pasazerow
        ReadData data = new ReadData();
        numberOfPassengers = data.NumberOfPassangers();
        for( int i = 0; i < numberOfPassengers; i++)
        {
            // Sprawdzamy czy piętro pasażera istnieje
            if( data.GetTargetFloor(i) < numberOfFloors && data.GetStartFloor(i) < numberOfFloors){
                // Dodajemy do listy stworzonego opisanego pasazera
                if( data.GetIsPrivileged(i) == 0){
                    passangerList.add(new Passanger(data.GetTime(i), data.GetStartFloor(i), data.GetTargetFloor(i)));
                }
                else {
                    passangerList.add(new PrivilegedPassanger(data.GetTime(i), data.GetStartFloor(i), data.GetTargetFloor(i)));
                }
            }
        }
    }

    public void AddingPassengers(List<ASpace> floors, int currentTime ){
        while(passangerList.get(0).getStartTime() == currentTime){
            floors.get(passangerList.get(0).getStartFloor()).AddPassenger(passangerList.get(0));
            passangerList.remove(0);
        }
    }
}


