package simulator;

import java.util.List;

/** Publiczny interfejs zarządzania Elevators */
public interface IManageElevators {

    /** Metoda zarządzania windami (Elevator) */
    void ManageElevators(List<IFloor> floors, List<IElevator> elevators);
}
