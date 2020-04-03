
package org.kickstats.geo1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the methods of the Vector class.
 * 
 * @author Chase Sonnemaker
 */
public class VectorTest {
    
    public VectorTest() {
    }

    /**
     * Test of get method, of class Vector.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Vector instance = new Vector(4, 3, 2);
        double expResult = 3;
        double result = instance.get(1);
        assertEquals(expResult, result, 1E-8);
    }

    /**
     * Test of toString method, of class Vector.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Vector instance = new Vector(4, 3, 2);
        String expResult = "(4.0, 3.0, 2.0, 1.0)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class Vector.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Vector v = new Vector(4, 3, 2, 1);
        Vector instance = new Vector(4, 3, 2);
        Vector expResult = new Vector(8, 6, 4);
        Vector result = instance.add(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// if
    }

    /**
     * Test of dot method, of class Vector.
     */
    @Test
    public void testDot() {
        System.out.println("dot");
        Vector v = new Vector(4, 3, 2);
        Vector instance = new Vector(4, 3, 2);
        double expResult = 29.0;
        double result = instance.dot(v);
        assertEquals(expResult, result, 1E-8);
    }

    /**
     * Test of magnitude method, of class Vector.
     */
    @Test
    public void testMagnitude() {
        System.out.println("magnitude");
        Vector instance = new Vector(4, 3, 2);
        double expResult = 5.38516480713;
        double result = instance.magnitude();
        assertEquals(expResult, result, 1E-8);
    }

    /**
     * Test of normalize method, of class Vector.
     */
    @Test
    public void testNormalize() {
        System.out.println("normalize");
        Vector instance = new Vector(4, 3, 2);
        Vector expResult = new Vector(0.74278135270,
                                      0.55708601453,
                                      0.37139067635);
        Vector result = instance.normalize();
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// if
    }
    
    /**
     * Test of cross method, of class Vector.
     */
    @Test
    public void testCross() {
        System.out.println("cross");
        Vector v = new Vector(2, 3, 4);
        Vector instance = new Vector(4, 3, 2);
        Vector expResult = new Vector(6, -12, 6);
        Vector result = instance.cross(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// if
    }
}
