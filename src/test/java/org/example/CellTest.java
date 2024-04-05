package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CellTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void OpenMethodSetToOpenState_getisOpenReturnsTrue(){
        Cell cell = new Cell();
        cell.Open();
        Assertions.assertTrue(cell.getisOpen());
    }

    @Test
    public void isHasFlagMethodReturnsTrueIfFlagRaisedInCell(){
        Cell cell = new Cell();
        cell.setHasFlag();
        Assertions.assertTrue(cell.isHasFlag());
    }
    @Test
    public void isHasFlagMethodReturnsFalseIfFlagNotRaisedInCell(){
        Cell cell = new Cell();
        Assertions.assertFalse(cell.isHasFlag());
    }

    @Test
    public void setHasFlagMethodAllowsFlagStatusToToggle (){
        Cell cell = new Cell();
        Assertions.assertFalse(cell.isHasFlag());
        cell.setHasFlag();
        Assertions.assertTrue(cell.isHasFlag());
        cell.setHasFlag();
        Assertions.assertFalse(cell.isHasFlag());
    }
    @Test
    public void setHasFlagMethodInvalidIfCellAlreadyOpen (){
        Cell cell = new Cell();
        cell.Open();
        cell.setHasFlag();
        Assertions.assertEquals("This cell is already open",outputStreamCaptor.toString().trim());
        Assertions.assertFalse(cell.isHasFlag());
    }
    @Test
    public void revealMethodReturnsFlagIfStateIsFlag(){
        Cell cell = new Cell();
        cell.setHasFlag();
        String cellState= cell.reveal();
        String FlagUnicode = " \uD83D\uDEA9";
        Assertions.assertEquals(FlagUnicode,cellState);
    }
    @Test
    public void revealMethodReturnsMineIfStateIsHasMine(){
        Cell cell = new Cell();
        cell.Open();
        cell.setHasMine();
        String cellState= cell.reveal();
        String MineUnicode = " \uD83D\uDCA3";
        Assertions.assertEquals(MineUnicode,cellState);
    }
    @Test
    public void revealMethodReturnsNeighbouringCounterIfStateIsOpen(){
        Cell cell = new Cell();
        cell.Open();
        cell.setHasMine();
        String cellState= cell.reveal();
        String NeighbourCounter = " " + cell.getNeighbouringMine() + " ";
        Assertions.assertEquals(NeighbourCounter,cellState);
    }


    @Test
    public void getisOpenMethodReturnsFalseIfCellIsNotOpen(){
        Cell cell = new Cell();
        Assertions.assertFalse(cell.getisOpen());
    }
    @Test
    public void getNeighbouringMineMethodReturnsNeighbourCounter(){
        Cell cell = new Cell();
        Assertions.assertEquals(0,cell.getNeighbouringMine());
        cell.addNeighbourMine();
        Assertions.assertEquals(1,cell.getNeighbouringMine());
        cell.addNeighbourMine();
        Assertions.assertEquals(2,cell.getNeighbouringMine());
    }
    @Test
    public void getHasMineMethodReturnsFalseIfCellHasNoMine(){
        Cell cell = new Cell();
        Assertions.assertFalse(cell.getHasMine());
    }
    @Test
    public void setHasMineMethodSetsStateOfCellToContainAMine(){
        Cell cell = new Cell();
        cell.setHasMine();
        Assertions.assertTrue(cell.getHasMine());
    }
    @Test
    public void AddNeighbourMineAddsOneToNeighbourCounter(){
        Cell cell = new Cell();
        Assertions.assertEquals(0,cell.getNeighbouringMine());
        cell.addNeighbourMine();
        Assertions.assertEquals(1,cell.getNeighbouringMine());
    }

}
