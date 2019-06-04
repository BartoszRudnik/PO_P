package simulator;

public interface IEnterElevator extends IPassengerControl {

    boolean showIsOpen();
    int GetNumberOfFreePlaces();
    void OpenDoor();
    void setTargetFloor(int targetFloor);
    void setTargetFloor(int targetFloor, int priority);
}
