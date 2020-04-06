
package org.kickstats.swing;

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
     * First test of get method, of class Vector.
     * 
     * Tests getting the first element of a 4 element vector.
     */
    @Test
    public void testGet1() {
        System.out.println("get");
        Vector instance = new Vector(1, 0, 0);
        double expResult = 1;
        double result = instance.get(0);
        assertEquals(expResult, result, 1E-8);
    }// testGet1()
    
    /**
     * Second test of get method, of class Vector.
     * 
     * Tests getting the last element of a 4 element vector.
     */
    @Test
    public void testGet2() {
        System.out.println("get");
        Vector instance = new Vector(0, 1, 0);
        double expResult = 1;
        double result = instance.get(3);
        assertEquals(expResult, result, 1E-8);
    }// testGet2
    
    /**
     * First test of set method, of class Vector.
     * 
     * Tests setting the first element of a 4 element vector to 10.
     */
    @Test
    public void testSet1() {
        System.out.println("set");
        int position = 0;
        double value = 10;
        Vector instance = new Vector(1, 0, 0);
        Vector expResult = new Vector(10, 0, 0);
        instance.set(position, value);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), instance.get(i), 1E-8);
        }// for
    }// testSet1()
    
    /**
     * Second test of set method, of class Vector.
     * 
     * Tests setting the last element of a 4 element vector to 5.
     */
    @Test
    public void testSet2() {
        System.out.println("set");
        int position = 3;
        double value = 5;
        Vector instance = new Vector(0, 1, 0);
        Vector expResult = new Vector(0, 1, 0, 5);
        instance.set(position, value);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), instance.get(i), 1E-8);
        }// for
    }// testSet2()

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
        Vector v = new Vector(4, 3, 2);
        Vector instance = new Vector(4, 3, 2);
        Vector expResult = new Vector(8, 6, 4);
        Vector result = instance.add(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// for
    }

    /**
     * Test of subtract method, of class Vector.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Vector v = new Vector(4, 3, 2);
        Vector instance = new Vector(8, 6, 4);
        Vector expResult = new Vector(4, 3, 2);
        Vector result = instance.subtract(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// for
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
        }// for
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
        }// for
    }
}
