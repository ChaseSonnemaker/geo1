
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
     * Test of getP0 method, of class Vector4D.
     */
    @Test
    public void testGetP0() {
        System.out.println("getP0");
        Vector4D instance = new Vector4D(4, 3, 2, 1);
        double expResult = 4;
        double result = instance.getP0();
        assertEquals(expResult, result, 1E-8);
    }

    /**
     * Test of getP1 method, of class Vector4D.
     */
    @Test
    public void testGetP1() {
        System.out.println("getP1");
        Vector4D instance = new Vector4D(4, 3, 2, 1);
        double expResult = 3;
        double result = instance.getP1();
        assertEquals(expResult, result, 1E-8);
    }

    /**
     * Test of getP2 method, of class Vector4D.
     */
    @Test
    public void testGetP2() {
        System.out.println("getP2");
        Vector4D instance = new Vector4D(4, 3, 2, 1);
        double expResult = 2.0;
        double result = instance.getP2();
        assertEquals(expResult, result, 1E-8);
    }

    /**
     * Test of getP3 method, of class Vector4D.
     */
    @Test
    public void testGetP3() {
        System.out.println("getP3");
        Vector4D instance = null;
        double expResult = 0.0;
        double result = instance.getP3();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Vector4D.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Vector4D instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Vector4D.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Vector4D v = null;
        Vector4D instance = null;
        Vector4D expResult = null;
        Vector4D result = instance.add(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dot method, of class Vector4D.
     */
    @Test
    public void testDot() {
        System.out.println("dot");
        Vector4D v = null;
        Vector4D instance = null;
        double expResult = 0.0;
        double result = instance.dot(v);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of magnitude method, of class Vector4D.
     */
    @Test
    public void testMagnitude() {
        System.out.println("magnitude");
        Vector4D instance = null;
        double expResult = 0.0;
        double result = instance.magnitude();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of translate method, of class Vector4D.
     */
    @Test
    public void testTranslate() {
        System.out.println("translate");
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        Vector4D instance = null;
        Vector4D expResult = null;
        Vector4D result = instance.translate(x, y, z);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rotateX method, of class Vector4D.
     */
    @Test
    public void testRotateX() {
        System.out.println("rotateX");
        double angle = 0.0;
        Vector4D instance = null;
        Vector4D expResult = null;
        Vector4D result = instance.rotateX(angle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rotateY method, of class Vector4D.
     */
    @Test
    public void testRotateY() {
        System.out.println("rotateY");
        double angle = 0.0;
        Vector4D instance = null;
        Vector4D expResult = null;
        Vector4D result = instance.rotateY(angle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rotateZ method, of class Vector4D.
     */
    @Test
    public void testRotateZ() {
        System.out.println("rotateZ");
        double angle = 0.0;
        Vector4D instance = null;
        Vector4D expResult = null;
        Vector4D result = instance.rotateZ(angle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scale method, of class Vector4D.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        Vector4D instance = null;
        Vector4D expResult = null;
        Vector4D result = instance.scale(x, y, z);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
