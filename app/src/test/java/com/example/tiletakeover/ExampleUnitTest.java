package com.example.tiletakeover;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

    Player P1 = new Player("rob");

    @Test
    public void checkWin()
    {
        assertEquals(false, P1.checkWin());
    }



    @Test
    public void getPosition()
    {
        assertEquals(0, P1.getPosition());
    }

   @Test
   public void setPosition(){
        P1.setPosition(25);
        assertEquals(25, P1.getPosition());
   }



//    @Test
////    public void addition_isCorrect() {
////        assertEquals(4, 2 + 2);
////    }


}