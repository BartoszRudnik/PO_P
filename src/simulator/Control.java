package simulator;

/** Klasa sterująca windami w budynku*/
public class Control implements IManageElevators{

    /** Metoda zarządzania windami w danym budynku
     * @param building
     * */
    @Override
    public void ManageElevators(Building building){
        for( int index = 0; index > building.GetNumberOfFloors(); index++){
            if( building.GetFloor(index).GetQueueLength() > 0){



            }
        }

    }
}
