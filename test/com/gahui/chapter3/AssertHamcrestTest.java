package com.gahui.chapter3;

import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
// ...

public class AssertHamcrestTest {

   @Test
   public void assertWithTolerance() {
      assertTrue(Math.abs((2.32 * 3) - 6.96) < 0.0005);
   }

}
