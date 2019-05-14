package simulator;

/** Klasa sterująca windami w budynku*/
public class Control implements IManageElevators{

    /** Głąwna metoda sterowania windami*/
    @Override
    public void ManageElevators( Building building)
    {
        /** Indeks najbliższej windy*/
        int WhichElevator = 0;
        /** Najmniejsza różnica między piętrem z największą kolejką a windą*/
        int MinDiference = building.GetNumberOfFloors();
        /** Aktualna różnica między piętrem z największą kolejką a windą*/
        int ActualDiference = 0;
        /** Index, numer piętra z największą kolejką*/
        int indexFloor = CheckOnWhichFloorTheMostPassangers(building);

        /** Wyszukiwanie minimalnej różnicy */
        for(int i = 0; i < building.GetNumberOfElevators(); i++)
        {
            /** Różnica między daną windą a piętrem z największą kolejką */
            if (building.GetElevator(i).GetNumberOfFreePlaces() > 0){
                ActualDiference = Math.abs( building.GetElevator(i).GetCurrentFloor() - indexFloor);
            }
            /** Jeśli dana różnica między piętrem a winą jest mniejsza od minimalnej, to wpisz ją za minimalną*/
            if(ActualDiference < MinDiference){
                // Przypisanie nowej minimalnej różnicy
                MinDiference = ActualDiference;
                // Pzypisanie nowego indeksu najbliższej windy
                WhichElevator = i;
            }
        }
        building.GetElevator(WhichElevator).GiveTargetFloor(indexFloor);
    }

    /** Metoda zwracająca numer piętra z największą liczbą czekających w kolejce*/
    @Override
    public int CheckOnWhichFloorTheMostPassangers( Building building)
    {
        /** Maksymalna ilosc pasazerow na pietrze*/
        int MaxNumberPassangers=0;

        /** Index piętra z największą liczbę pasażerów */
        int MostPassangerFloor = -1;

        /** Wyszukiwanie piętra z największą liczbą oczekujących*/
        for(int i = 0; i <= building.GetNumberOfFloors(); i++)
        {
            if(building.GetFloor(i).GetQueueLength() > MaxNumberPassangers)
            {
                MaxNumberPassangers = building.GetFloor(i).GetQueueLength();
                MostPassangerFloor = i;
            }
        }
        return MostPassangerFloor;
    }

    /** Nadanie nowego celu windzie*/
    @Override
    public void setTheNewTargetElevator(Elevator elevator, int newTarget)
    {
        elevator.GiveTargetFloor(newTarget);
    }
}
