package simulator;

/**
 * Publiczny interfejs piętra
 * */
public interface IFloor {

    /** Metoda zwracająca długość kolejki na piętrze*/
    int GetQueueLength();

    /** Metoda zwracająza informację o tym, czy piętro wzywa widę*/
    boolean getCall();

    /** Metoda wezwania windy*/
    void CallElevator();
}
