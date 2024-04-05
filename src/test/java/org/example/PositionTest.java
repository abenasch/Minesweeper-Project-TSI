package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    void getXReturnsTheXValue(){
        Position position = new Position(5, 5);
        Assertions.assertEquals(5,position.getX());
    }
    @Test
    void getYReturnsTheYValue(){
        Position position = new Position(5, 5);
        Assertions.assertEquals(5,position.getY());
    }
    @Test
    void setXSetsNewValue(){
        Position position = new Position();
        position.setX(8);
        Assertions.assertEquals(8,position.getX());
    }
    @Test
    void setYSetsNewValue(){
        Position position = new Position(5, 5);
        position.setY(2);
        Assertions.assertEquals(2,position.getY());
    }


}
