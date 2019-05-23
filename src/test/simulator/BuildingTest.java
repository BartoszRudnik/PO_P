package simulator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {
    Building testbuilding=new Building(5,10);
    @Test
    void NumberOfFloor() {
        assertTrue(testbuilding.GetNumberOfFloors()==5);
    }

    @Test
    void NumberofElevators() {
        assertTrue(testbuilding.GetNumberOfElevators()==10);
    }
}