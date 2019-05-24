package simulator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorTest {
    Elevator testElevator=new Elevator(5);
    @Test
    void maxNumberOfPassanger()
    {
        assertTrue(testElevator.MaxNumberPassangers()==5);
    }
    /** Test sprawdzajacy czy zgodnie z konstruktorem obecne pietro jest ustawione na wartosc 0 */
    @Test
    void CurrentFloor()
    {
        assertTrue(testElevator.GetCurrentFloor()==0);
    }

    /** W konstruktorze ustawiamy winde na zamknieta */
    @Test
    void IsOpen()
    {
        assertTrue(testElevator.showIsOpen()==false);
    }
}