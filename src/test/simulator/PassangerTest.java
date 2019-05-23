package simulator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassangerTest {

    Passanger testpassanger=new Passanger(10,2,5);

    @Test
    void startTime() {
        assertTrue(testpassanger.getStartTime()==10);
    }

    @Test
    void startFloor() {
        assertTrue(testpassanger.getStartFloor()==2);
    }

    @Test
    void targetFloor() {
        assertTrue(testpassanger.getTargetFloor()==5);
    }
}