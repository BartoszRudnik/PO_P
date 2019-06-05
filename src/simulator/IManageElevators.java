package simulator;

import java.util.List;

/** Publiczny interfejs zarządzania Elevators */
public interface IManageElevators {

    /** Metoda zarządzania windami (Elevator)
     * @param floors piętra budynku
     * @param  elevators windy budynku
     * */
    void ManageElevators(List<IFloor> floors, List<IElevator> elevators);
}
