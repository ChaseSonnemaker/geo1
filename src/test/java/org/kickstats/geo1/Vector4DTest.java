
package org.kickstats.geo1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the methods of the Vector4D class.
 * 
 * @author Chase Sonnemaker
 */
public class Vector4DTest {
    
    public Vector4DTest() {
    }

    /**
     * Test of get method, of class Vector4D.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Vector4D instance = new Vector4D(4, 3, 2);
        double expResult = 3;
        double result = instance.get(1);
        assertEquals(expResult, result, 1E-8);
    }

    /**
     * Test of toString method, of class Vector4D.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Vector4D instance = new Vector4D(4, 3, 2);
        String expResult = "(4.0, 3.0, 2.0, 1.0)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class Vector4D.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Vector4D v = new Vector4D(4, 3, 2, 1);
        Vector4D instance = new Vector4D(4, 3, 2, 1);
        Vector4D expResult = new Vector4D(8, 6, 4, 2);
        Vector4D result = instance.add(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// if
    }

    /**
     * Test of dot method, of class Vector4D.
     */
    @Test
    public void testDot() {
        System.out.println("dot");
        Vector4D v = new Vector4D(4, 3, 2);
        Vector4D instance = new Vector4D(4, 3, 2);
        double expResult = 30.0;
        double result = instance.dot(v);
        assertEquals(expResult, result, 1E-8);
    }

    /**
     * Test of magnitude method, of class Vector4D.
     */
    @Test
    public void testMagnitude() {
        System.out.println("magnitude");
        Vector4D instance = new Vector4D(4, 3, 2);
        double expResult = 5.47722557505;
        double result = instance.magnitude();
        assertEquals(expResult, result, 1E-8);
    }

    /**
     * Test of normalize method, of class Vector4D.
     */
    @Test
    public void testNormalize() {
        System.out.println("normalize");
        Vector4D instance = new Vector4D(4, 3, 2);
        Vector4D expResult = new Vector4D(0.73029674334,
                                          0.54772255750,
                                          0.36514837167,
                                          0.18257418583);
        Vector4D result = instance.normalize();
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// if
    }
    
    /**
     * Test of cross method, of class Vector4D.
     */
    @Test
    public void testCross() {
        System.out.println("cross");
        Vector4D v = new Vector4D(2, 3, 4);
        Vector4D instance = new Vector4D(4, 3, 2);
        Vector4D expResult = new Vector4D(6, -12, 6);
        Vector4D result = instance.cross(v);
        for(int i = 0; i < 4; i++) {
            assertEquals(expResult.get(i), result.get(i), 1E-8);
        }// if
    }
}
