
package org.kickstats.geo1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the methods of the Matrix4D class.
 * 
 * @author Chase Sonnemaker
 */
public class Matrix4DTest {
    
    public Matrix4DTest() {
    }

    /**
     * Test of get method, of class Matrix4D.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int row = 0;
        int column = 0;
        Matrix4D instance = new Matrix4D();
        double expResult = 1.0;
        double result = instance.get(row, column);
        assertEquals(expResult, result, 1E-8);
    }

//    /**
//     * Test of toString method, of class Matrix4D.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Matrix4D instance = new Matrix4D();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of identity method, of class Matrix4D.
     */
    @Test
    public void testIdentity() {
        System.out.println("identity");
        Matrix4D instance = new Matrix4D();
        instance.identity();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    assertEquals(instance.get(i, j), 1);
                }// if
                else {
                    assertEquals(instance.get(i, j), 0);
                }// else
            }// for
        }// for
    }

    /**
     * Test of multiply method, of class Matrix4D.
     */
    @Test
    public void testMultiply_Matrix4D() {
        System.out.println("multiply");
        Matrix4D m = null;
        Matrix4D instance = new Matrix4D();
        Matrix4D expResult = null;
        Matrix4D result = instance.multiply(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class Matrix4D.
     */
    @Test
    public void testMultiply_Vector4D() {
        System.out.println("multiply");
        Vector4D v = null;
        Matrix4D instance = new Matrix4D();
        Vector4D expResult = null;
        Vector4D result = instance.multiply(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of translate method, of class Matrix4D.
     */
    @Test
    public void testTranslate() {
        System.out.println("translate");
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        Matrix4D instance = new Matrix4D();
        instance.translate(x, y, z);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rotateX method, of class Matrix4D.
     */
    @Test
    public void testRotateX() {
        System.out.println("rotateX");
        double angle = 0.0;
        Matrix4D instance = new Matrix4D();
        instance.rotateX(angle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rotateY method, of class Matrix4D.
     */
    @Test
    public void testRotateY() {
        System.out.println("rotateY");
        double angle = 0.0;
        Matrix4D instance = new Matrix4D();
        instance.rotateY(angle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rotateZ method, of class Matrix4D.
     */
    @Test
    public void testRotateZ() {
        System.out.println("rotateZ");
        double angle = 0.0;
        Matrix4D instance = new Matrix4D();
        instance.rotateZ(angle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scale method, of class Matrix4D.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        Matrix4D instance = new Matrix4D();
        instance.scale(x, y, z);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
