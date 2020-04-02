
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
     * Test of getP1 method, of class Vector4D.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Vector4D instance = new Vector4D(4, 3, 2, 1);
        double expResult = 3;
        double result = instance.get(2);
        assertEquals(expResult, result, 1E-8);
    }

    /**
     * Test of toString method, of class Vector4D.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Vector4D instance = new Vector4D(4, 3, 2, 1);
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
        assertEquals(expResult.getP0(), result.getP0(), 1E-8);
        assertEquals(expResult.getP1(), result.getP1(), 1E-8);
        assertEquals(expResult.getP2(), result.getP2(), 1E-8);
        assertEquals(expResult.getP3(), result.getP3(), 1E-8);
    }

    /**
     * Test of dot method, of class Vector4D.
     */
    @Test
    public void testDot() {
        System.out.println("dot");
        Vector4D v = new Vector4D(4, 3, 2, 1);
        Vector4D instance = new Vector4D(4, 3, 2, 1);
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
        Vector4D instance = new Vector4D(4, 3, 2, 1);
        double expResult = 5.47722557505;
        double result = instance.magnitude();
        assertEquals(expResult, result, 1E-8);
    }

    /**
     * Test of translate method, of class Vector4D.
     */
    @Test
    public void testTranslate() {
        System.out.println("translate");
        double x = 2.0;
        double y = 2.0;
        double z = 2.0;
        Vector4D instance = new Vector4D(4, 3, 2, 1);
        Vector4D expResult = new Vector4D(6, 5, 4, 1);
        Vector4D result = instance.translate(x, y, z);
        assertEquals(expResult.getP0(), result.getP0(), 1E-8);
        assertEquals(expResult.getP1(), result.getP1(), 1E-8);
        assertEquals(expResult.getP2(), result.getP2(), 1E-8);
        assertEquals(expResult.getP3(), result.getP3(), 1E-8);
    }

//    /**
//     * Test of rotateX method, of class Vector4D.
//     */
//    @Test
//    public void testRotateX() {
//        System.out.println("rotateX");
//        double angle = 0.0;
//        Vector4D instance = null;
//        Vector4D expResult = null;
//        Vector4D result = instance.rotateX(angle);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of rotateY method, of class Vector4D.
//     */
//    @Test
//    public void testRotateY() {
//        System.out.println("rotateY");
//        double angle = 0.0;
//        Vector4D instance = null;
//        Vector4D expResult = null;
//        Vector4D result = instance.rotateY(angle);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of rotateZ method, of class Vector4D.
//     */
//    @Test
//    public void testRotateZ() {
//        System.out.println("rotateZ");
//        double angle = 0.0;
//        Vector4D instance = null;
//        Vector4D expResult = null;
//        Vector4D result = instance.rotateZ(angle);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of scale method, of class Vector4D.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        double x = 2.0;
        double y = 2.0;
        double z = 2.0;
        Vector4D instance = new Vector4D(4, 3, 2, 1);
        Vector4D expResult = new Vector4D(8, 6, 4, 1);
        Vector4D result = instance.scale(x, y, z);
        assertEquals(expResult.getP0(), result.getP0(), 1E-8);
        assertEquals(expResult.getP1(), result.getP1(), 1E-8);
        assertEquals(expResult.getP2(), result.getP2(), 1E-8);
        assertEquals(expResult.getP3(), result.getP3(), 1E-8);
    }
    
}
