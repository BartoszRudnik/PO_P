package simulator;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa tworząca wszystkie obiekty pasarzerów w symulacji
 * Wyorzystując klasę ReadData tworzy pasażerów argumentami dostarczonymi przez nią
 * */
public class PassengerCreator
{
    /** Pole zawierające liczbę danych pasażerów, które zawiera ReadData*/
    private int numberOfPassengers;

    private List<Passanger> passangerList = new ArrayList <>();
    /** Tworzymy obiekt do wczytywania danych */
    ReadData data = new ReadData();

    PassengerCreator( int numberOfFloors)
    {
        // Wyznaczamy liczbe pasazerow
        numberOfPassengers = data.NumberOfPassangers();
        for( int i = 0; i < numberOfPassengers; i++)
        {
            // Sprawdzamy czy piętro pasażera istnieje
            if( data.GetTargetFloor(i) <= numberOfFloors && data.GetStartFloor(i) <= numberOfFloors){
                // Dodajemy do listy stworzonego opisanego pasazera
                if( data.GetIsPrivileged(i) == 0){
                    passangerList.add(new Passanger(data.GetTime(i),data.GetStartFloor(i),data.GetTargetFloor(i)));
                }
                else {
                    passangerList.add(new PrivilegedPassanger(data.GetTime(i), data.GetStartFloor(i), data.GetTargetFloor(i)));
                }
            }
        }
        data = null;
    }

    public void AddingPassengers( Building building, int currentTime ){
        while(passangerList.get(0).getStartTime() == currentTime){
            building.GetFloor(passangerList.get(0).getStartFloor()).AddPassenger(passangerList.get(0));
            passangerList.remove(0);
        }
    }

    /** Metoda wyznaczajaca liczbe wczytanych zestawow danych pasazerow */
    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    /** Zwracanie pasażera -- do testów*/
    public Passanger ReturnPassenger(int index)
    {
        return passangerList.get(index);
    }
}


