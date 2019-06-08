package simulator;

/**
 * Publiczna klasa piętra
 * Zawiera w sobie kolejkę pasażerów
 * */
public class Floor extends ASpace implements IFloor{

    /** Pole wezwanie windy */
    private boolean call = false;

    /**Metoda Pokazująca długość kolejki*/
    @Override
    public int GetQueueLength(){
        return passengerList.size();
    }

    /** Metoda dodająca pasażera
     * @param passanger dodawany pasażer
     * */
    @Override
    public void AddPassenger( Passanger passanger){
        if( passanger instanceof  PrivilegedPassanger){
            passengerList.add(0, passanger);
        }
        else
            passengerList.add(passanger);
        CallElevator();
    }

    /** Metoda wypuszczania pasażerów do windy
     * @param elevator winda mająca stać na piętrze
     * */
    public void LetPassengersOut(IEnterElevator elevator) {
        // Tutaj pasażerowie są dodawani do windy
        while (passengerList.size() > 0){
            if(!passengerList.get(0).GoInto(elevator, this)){
                break;
            }
        }
        if(passengerList.size() == 0) {
            call = false;
        }
    }

    /** Metoda wezwania windy*/
    public void CallElevator(){
        call = true;
    }

    /** Metoda zwracająca wartość call */
    public boolean getCall(){
        return call;
    }
}
