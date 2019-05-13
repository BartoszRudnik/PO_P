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
        int WhichElevator=0,MinDiference=elevatorList.size(),ActualDiference=0;
        /** GetNumberOfFreePlaces() */
        for(int i=0;i<elevatorList.size();i++)
        {
            if (Elevator[i].GetNumberOfFreePlaces() > 0)
            {
                ActualDiference=Math.abs(Elevator.GiveTargetFloor()-Elevator.GetCurrentFloor);
            }
            if(ActualDiference<MinDiference)
            {
                MinDiference=ActualDiference;
                WhichElevator=i;
            }
        }
        if(Elevator[WhichElevator].GetCurrentFloor()>Elevator.GiveTargetFloor())
            Elevator[WhichElevator].GoDown(Elevator.GiveTargetFloor());
        else
            Elevator[WhichElevator].GoUp(Elevator.GiveTargetFloor());
    }

    @Override
    private int CheckOnWhichFloorTheMostPassangers()
    {
        /** Maksymalna ilosc pasazerow na pietrze*/
        int MaxNumberPassangers=0;
        /** Numer 'maksymalnego pietra' */
        int MostPassangerFloor=-1;
        for(int i=0;i<=numberOfFloors;i++)
        {
            if(floorList.get(i).GetQueueLength()>MaxNumberPassangers)
            {
                MaxNumberPassangers=floorList.get(i).GetQueueLength();
                MostPassangerFloor=i;
            }
        }
        return MostPassangerFloor;
    }

    @Override
    private void GiveTheNewTargetElevator(Elevator elevator,int target)
    {
        elevator.GiveTargerFloor(target);
    }
}
