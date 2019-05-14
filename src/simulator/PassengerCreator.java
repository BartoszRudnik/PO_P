package simulator;
import java.util.ArrayList;
import java.util.List;

/** Klasa tworząca wszystkie obiekty pasarzerów w symulacji*/
public class PassengerCreator {
    private int numberOfPassengers;

    private List<Passanger> passangerList = new ArrayList <>();
    ReadData data = new ReadData();

    PassengerCreator( int numberOfFloors){

        numberOfPassengers = data.NumberOfPassangers();
        for( int i = 0; i < numberOfPassengers; i++){
            if( data.GetTargetFloor(i) <= numberOfFloors && data.GetStartFloor(i) <= numberOfFloors){

            }
        }
    }


    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
