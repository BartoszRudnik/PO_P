package simulator;
import java.util.ArrayList;
import java.util.List;

/** Publiczna klasa budynku*/
public class Building implements IManageElevators
{

    /** Lista pięter*/
    List<Floor> floorList = new ArrayList <>();
    /** Lista wind*/
    List<Elevator> elevatorList = new ArrayList <>();
    /** Maksymalna liczba pasazerow */
    private int MaxPassangerNumber=8;

    /** Konstruktor klasy Building*/
    Building( int numberOfFloors, int numberOfElevators)
    {
        /** Dodawanie pięter do budynku */
        for( int i = 0; i < numberOfFloors;i++)
        {
            floorList.add(new Floor());
        }
        /** Dodawanie wind do budynku */
        for( int i = 0; i < numberOfElevators;i++)
        {
            elevatorList.add(new Elevator(MaxPassangerNumber));
        }
    }

    @Override
    public void ManageElevators()
    {
        /** Indeks najbliższej windy*/
        int WhichElevator = 0;
        /** Najmniejsza różnica między piętrem z największą kolejką a windą*/
        int MinDiference = floorList.size();
        /** Aktualna różnica*/
        int ActualDiference = 0;
        /** Index, numer piętra z największą kolejką*/
        int indexFloor = CheckOnWhichFloorTheMostPassangers();

        /** Wyszukiwanie minimalnej różnicy */
        for(int i = 0; i < elevatorList.size(); i++)
        {
            /** Różnica między daną windą a piętrem z największą kolejką */
            if (elevatorList.get(i).GetNumberOfFreePlaces() > 0){
                ActualDiference = Math.abs( elevatorList.get(i).GetCurrentFloor() - indexFloor);
            }
            /** Jeśli dana różnica między piętrem a winą jest mniejsza od minimalnej, to wpisz ją za minimalną*/
            if(ActualDiference < MinDiference){
                // Przypisanie nowej minimalnej różnicy
                MinDiference = ActualDiference;
                // Pzypisanie nowego indeksu najbliższej windy
                WhichElevator = i;
            }
        }
        elevatorList.get(WhichElevator).GiveTargetFloor(indexFloor);
    }

    @Override
    private int CheckOnWhichFloorTheMostPassangers()
    {
        /** Maksymalna ilosc pasazerow na pietrze*/
        int MaxNumberPassangers=0;

        /** Index piętra z największą liczbę pasażerów */
        int MostPassangerFloor = -1;

        for(int i=0; i<=floorList.size(); i++)
        {
            if(floorList.get(i).GetQueueLength() > MaxNumberPassangers)
            {
                MaxNumberPassangers = floorList.get(i).GetQueueLength();
                MostPassangerFloor = i;
            }
        }
        return MostPassangerFloor;
    }

    @Override
    public void GiveTheNewTargetElevator(Elevator elevator,int newTarget)
    {
        elevator.GiveTargetFloor(newTarget);
    }
}